package office.word

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.extensions.UIID
import kotlinx.extensions.justifySelf
import kotlinx.extensions.to
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import react.*
import reakt.Grid
import styled.css
import styled.styledDiv
import styled.styledInput
import theme.ThemeConsumer
import theme.onSurfaceColor
import theme.surfaceColor
import office.word.ColorTool.Props
import office.word.ColorTool.State

@JsExport
class ColorTool(p: Props) : RComponent<Props, State>(p) {

    private val inputId = UIID.getId("color-picker")

    private val input get() = inputId.get<HTMLElement>()

    class Props(
        val text: String,
        val defaultColor: String,
        val onColorChanged: (String) -> Unit
    ) : RProps

    class State(var color: String) : RState

    init {
        state = State(p.defaultColor)
    }

    override fun componentWillUnmount() {
        inputId.release()
    }

    fun Color.isEqualTo(c: Color) = withAlpha(0.0).value == c.withAlpha(0.0).value

    override fun RBuilder.render(): dynamic = Grid(rows = "1fr auto", gap = "0") {
        css {
            cursor = Cursor.pointer
            userSelect = UserSelect.none
        }

        attrs.onClickFunction = { input.click() }

        styledDiv {
            css {
                justifySelf = JustifyContent.center
                alignSelf = Align.center
                fontWeight = FontWeight.bold
                fontSize = 1.3.em
            }
            +props.text
        }

        ThemeConsumer { theme ->
            styledDiv {
                css {
                    justifySelf = JustifyContent.center
                    alignItems = Align.stretch
                    position = Position.relative
                    height = 0.3.em
                    width = 70.pct
                    backgroundColor = Color(state.color)
                    val c = if (Color(state.color).isEqualTo(theme.surfaceColor)) {
                        theme.onSurfaceColor.value
                    } else {
                        state.color
                    }
                    border = "solid 1px $c"
                }

                styledInput(InputType.color) {
                    css {
                        display = Display.none
                    }
                    attrs.id = inputId.value
                    attrs.onChangeFunction = {
                        it.target?.to<HTMLInputElement>()?.value?.let { c ->
                            setState { color = c }
                            props.onColorChanged(c)
                        }
                    }
                }
            }
        }
    }
}

internal fun RBuilder.ForeColor(onColorChanged: (String) -> Unit) = ThemeConsumer { theme ->
    child(ColorTool::class.js, Props("A", theme.onSurfaceColor.value, onColorChanged)) {}
}

internal fun RBuilder.HighliteColor(onColorChanged: (String) -> Unit) = ThemeConsumer { theme ->
    child(ColorTool::class.js, Props("ab", theme.surfaceColor.value, onColorChanged)) {}
}