package ru.netology.testing.uiautomator

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.netology.testing.uiautomator.pages.MainScreen

const val SETTINGS_PACKAGE = "com.android.settings"
const val MODEL_PACKAGE = "ru.netology.testing.uiautomator"
const val TIMEOUT = 5000L

@RunWith(AndroidJUnit4::class)
class ChangeTextTest {

    private lateinit var device: UiDevice
    private lateinit var mainScreen: MainScreen
    private val textToSet = "Netology"

    private fun waitForPackage(packageName: String) {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        context.startActivity(intent)
        device.wait(Until.hasObject(By.pkg(packageName)), TIMEOUT)
    }

    @Before
    fun beforeEachTest() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()
        val launcherPackage = device.launcherPackageName
        device.wait(Until.hasObject(By.pkg(launcherPackage)), TIMEOUT)
        mainScreen = MainScreen(device)
    }

    @Test
    fun testChangeText() {
        waitForPackage(MODEL_PACKAGE)
        mainScreen.setUserInput(textToSet)
        mainScreen.clickButtonChange()
        val result = mainScreen.getTextFromResultField()
        assertEquals(result, textToSet)
    }

    @Test
    fun testEmptyStringInput() {
        waitForPackage(MODEL_PACKAGE)
        val initialText = mainScreen.getTextFromResultField()
        mainScreen.setUserInput(" ")
        mainScreen.clickButtonChange()
        val resultText = mainScreen.getTextFromResultField()
        assertEquals(resultText, initialText)
    }

    @Test
    fun testOpenNewActivity() {
        waitForPackage(MODEL_PACKAGE)
        mainScreen.setUserInput(textToSet)
        mainScreen.openNewActivity()
        waitForPackage(MODEL_PACKAGE)
        val displayedText = device.findObject(By.res(MODEL_PACKAGE, "text")).text
        assertEquals(displayedText, textToSet)
    }
}