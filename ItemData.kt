 data class ItemData(
        var originalPos: Int,
        var originalValue: Any?,
        var type: String? = null,
        var info: String? = null
    )
// -----------------------
    fun main() {
        val result = processList(listOf(25, "Hola", null, false, 2.0))
        println(result)
    }
    fun processList(inputList: List<Any?>?): List<ItemData>? {
        var resultado = ArrayList<ItemData>()
        var cont: Int = -1
        var type: String? = null
        var info: String? = null

        if (inputList != null) {
            for (item in inputList){
                cont = cont + 1

                when (item) {
                    is String -> {
                        type = "String"
                        var a = item.length
                        info = "L"+ a }
                    is Int -> {
                        type = "Int"
                        var a = 0
                        if (item %10 == 0){ a = 10 }
                        if (item %5 == 0){ a = 5 }
                        if (item %2 == 0){ a = 2 }
                        info = "M"+ a }
                    is Boolean -> {
                        type = "Boolean"
                        if (item) { info = "verdadero" }
                        else { info = "false" }
                    }
                    else -> {
                        type = null
                        info = null
                    }
                }
                if (item != null){
                    resultado.add(ItemData(cont,(item ?: null),type,info))
                }
            }
        }
        return resultado
    }
