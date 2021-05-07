package office.word

interface ITextEditorController {
    fun bold()
    fun italic()
    fun underline()
    fun strikeThrough()
    fun alignLeft()
    fun alignCenter()
    fun alignRight()
    fun alignJustify()
    fun cut()
    fun copy()
    fun paste()
    fun setHeading(h: String)
    fun setNormal()
    fun setFontName(f: String)
    fun setFontSize(size: String)
    fun setForeColor(c: String)
    fun setHighliteColor(c: String)
    fun insertImage(url: String)
    fun insertHTML(html: String)
    fun increaseFontSize()
    fun decreaseFontSize()
    fun removeFormat()
    fun formatBlock(tag: String)
    fun enableInlineTableEditing()
    fun enableObjectResizing()
    fun insertText(txt: String)
    fun insertParagraph(paragraph: String)
    fun indent()
    fun outdent()
    fun subscript()
    fun superscript()
    fun styleWithCss()
    fun undo()
    fun redo()
    fun unorderedList()
    fun orderedList()
    fun paragraph()
    fun insertLink(url: String)
    fun unlink()
    fun insertHorizontalRule()
    fun save()
    fun onSave(handler: (String) -> Unit)
}