package com.motiky.unscramble.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.motiky.unscramble.data.MAX_NO_OF_WORDS
import com.motiky.unscramble.data.SCORE_INCREASE
import com.motiky.unscramble.data.WordsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {
    private val _uistate = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uistate.asStateFlow()

    private lateinit var currentWord: String

    private var usedWords: MutableSet<String> = mutableSetOf()

    var userGuess by mutableStateOf("")
        private set

    private fun pickRandomWordAndShuffle(): String{
        currentWord = WordsData.allWords.random()
        if(usedWords.contains(currentWord)){
            return pickRandomWordAndShuffle()
        } else {
            return shuffleCurrentWord(currentWord)
        }
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        tempWord.shuffle()

        while (String(tempWord) == word){
            shuffleCurrentWord(word)
        }
        return String(tempWord)
    }

    fun resetGame(){
        usedWords.clear()
        _uistate.value = GameUiState(
            currentScrambledWord = pickRandomWordAndShuffle(),
            isGameOver = false,
            isGuessedWordWrong = false,
            score = 0,
            currentWordCount = 1
        )
    }

    init {
        resetGame()
    }

    fun updateUserGuess(guessedWord: String) {
        userGuess = guessedWord
    }

    fun checkUserGuess() {
        if(userGuess.equals(currentWord, ignoreCase = true)){
            val updatedScore = _uistate.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
            updateUserGuess("")
            usedWords.add(currentWord)
        } else {
            _uistate.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
    }

    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size == MAX_NO_OF_WORDS) {
            _uistate.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else {
            _uistate.update { currentState->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    score = updatedScore,
                    currentWordCount = currentState.currentWordCount.inc()
                )
            }
        }
    }

    fun skipWord() {
        usedWords.add(currentWord)
        updateUserGuess("")
        updateGameState(_uistate.value.score)
    }

    fun getUnscrambledWord(): String {
        return currentWord
    }
}