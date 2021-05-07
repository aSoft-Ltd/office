package office.word.sample

import applikation.konfig
import kotlinx.browser.document
import kotlinx.browser.window
import office.word.WordEditor
import react.dom.render
import reakt.Surface
import theme.AquaGreenTheme
import theme.DarkGrayTheme
import theme.ThemeProvider
import theme.currentTheme

fun main() {
    val kfg = konfig()
    val `package`: String by kfg
    console.log("Work :$`package`")
    render(document.getElementById("root")) {
//        Grid(cols = "1fr 4fr") {
//            Surface {
//                PostEditor(content = "Test Content") {
//                    window.alert(it)
//                }
//            }
        currentTheme.value = DarkGrayTheme()
        ThemeProvider(currentTheme.value) {
            Surface {
                WordEditor(
                    content = """
                                    <h1>Lyrics</h1>
                        <p>Started from the bottom now we here</p>
                    """.trimIndent(),
                    onSave = { word -> window.alert(word) }
                )
            }
        }
//        }
    }
}