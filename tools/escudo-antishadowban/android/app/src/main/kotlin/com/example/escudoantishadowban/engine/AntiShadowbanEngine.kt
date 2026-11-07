package com.example.escudoantishadowban.engine

object AntiShadowbanEngine {

    enum class Mode {
        ZWSP,
        HOMOGLYPH,
        HYBRID
    }

    private val SENSITIVE_WORDS = listOf(
        "denuncia", "denunciar", "penal", "pericial", "fiscalia", "fiscalía", "fiscal",
        "fraude", "electoral", "corrupcion", "corrupción", "delito", "robo", "ladron",
        "sabotaje", "rootkit", "hackeo", "hacker", "ataque", "victima", "víctima",
        "muerte", "asesinato", "amenaza", "peligro", "asilo", "violencia", "cne",
        "registraduria", "registraduría", "protesta", "censura", "shadowban", "odio"
    )

    private val HOMOGLYPHS = mapOf(
        'a' to 'а', // Cyrillic U+0430
        'e' to 'е', // Cyrillic U+0435
        'o' to 'о', // Cyrillic U+043E
        'p' to 'р', // Cyrillic U+0440
        'c' to 'с', // Cyrillic U+0441
        'y' to 'у', // Cyrillic U+0443
        'x' to 'х', // Cyrillic U+0445
        'i' to 'і', // Cyrillic U+0456
        'A' to 'А', // Cyrillic U+0410
        'E' to 'Е', // Cyrillic U+0415
        'O' to 'О', // Cyrillic U+041E
        'P' to 'Р', // Cyrillic U+0420
        'C' to 'С', // Cyrillic U+0421
        'T' to 'Т', // Cyrillic U+0422
        'H' to 'Н', // Cyrillic U+041D
        'M' to 'М'  // Cyrillic U+041C
    )

    data class MutationResult(
        val text: String,
        val mutationCount: Int
    )

    fun process(text: String, mode: Mode): MutationResult {
        if (text.isBlank()) return MutationResult("", 0)

        var count = 0
        val wordRegex = Regex("([a-zA-ZáéíóúÁÉÍÓÚñÑ]{3,})")

        val result = when (mode) {
            Mode.ZWSP -> {
                wordRegex.replace(text) { match ->
                    val word = match.value
                    val lower = word.lowercase()
                    val isSens = SENSITIVE_WORDS.any { lower.contains(it) }
                    count++
                    if (isSens) {
                        val mid = word.length / 2
                        word.substring(0, mid) + "\u200B" + word.substring(mid)
                    } else {
                        word.substring(0, 2) + "\u200B" + word.substring(2)
                    }
                }
            }
            Mode.HOMOGLYPH -> {
                val sb = StringBuilder()
                for (ch in text) {
                    val replacement = HOMOGLYPHS[ch]
                    if (replacement != null && Math.random() < 0.65) {
                        count++
                        sb.append(replacement)
                    } else {
                        sb.append(ch)
                    }
                }
                sb.toString()
            }
            Mode.HYBRID -> {
                wordRegex.replace(text) { match ->
                    count++
                    val word = match.value
                    val sb = StringBuilder()
                    for (ch in word) {
                        sb.append(HOMOGLYPHS[ch] ?: ch)
                    }
                    val mutWord = sb.toString()
                    val mid = mutWord.length / 2
                    mutWord.substring(0, mid) + "\u200B" + mutWord.substring(mid)
                }
            }
        }

        return MutationResult(result, count)
    }
}

