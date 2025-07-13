package ru.netology.testing.uiautomator.pages

import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import ru.netology.testing.uiautomator.MODEL_PACKAGE

class MainScreen(private val device: UiDevice) {

    companion object {
        const val USER_INPUT_ID = "userInput"
        const val BUTTON_CHANGE_ID = "buttonChange"
        const val TEXT_TO_BE_CHANGED_ID = "textToBeChanged"
        const val BUTTON_ACTIVITY_ID = "buttonActivity"
    }

    fun setUserInput(text: String) {
        device.findObject(By.res(MODEL_PACKAGE, USER_INPUT_ID))?.text = text
    }

    fun clickButtonChange() {
        device.findObject(By.res(MODEL_PACKAGE, BUTTON_CHANGE_ID))?.click()
    }

    fun getTextFromResultField(): String {
        return device.findObject(By.res(MODEL_PACKAGE, TEXT_TO_BE_CHANGED_ID))?.text ?: ""
    }

    fun openNewActivity() {
        device.findObject(By.res(MODEL_PACKAGE, BUTTON_ACTIVITY_ID))?.click()
    }
}