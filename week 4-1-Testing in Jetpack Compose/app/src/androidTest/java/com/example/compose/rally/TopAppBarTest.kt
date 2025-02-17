package com.example.compose.rally

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setupTest() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTheme {
                RallyTopAppBar(
                    allScreens = allScreens,
                    onTabSelected = { /*TODO*/ },
                    currentScreen = RallyScreen.Accounts
                )
            }
        }
    }

    @Test
    fun rallyTopAppBarTest() {
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()

        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertExists()

        composeTestRule
            .onNode(
                hasText(RallyScreen.Accounts.name.uppercase(Locale.getDefault())) and
                        hasParent(
                            hasContentDescription(RallyScreen.Accounts.name)
                        ),
                useUnmergedTree = true
            )
            .assertExists()
    }

    @Test
    fun rallyClickOverviewTest() {
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Overview.name)
            .performClick()
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Overview.name)
            .assertIsDisplayed()
    }

}