package com.example.escudoantishadowban.ui.main

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.escudoantishadowban.engine.AntiShadowbanEngine

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var inputText by remember { mutableStateOf("") }
    var outputText by remember { mutableStateOf("") }
    var mutationCount by remember { mutableStateOf(0) }
    var selectedMode by remember { mutableStateOf(AntiShadowbanEngine.Mode.ZWSP) }

    val bgColor = Color(0xFF090D16)
    val cardBg = Color(0xFF111827)
    val cardBorder = Color(0xFF1F293D)
    val accentCyan = Color(0xFF38BDF8)
    val accentGreen = Color(0xFF22C55E)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Encabezado
        Surface(
            shape = RoundedCornerShape(999.dp),
            color = accentCyan.copy(alpha = 0.12f),
            border = androidx.compose.foundation.BorderStroke(1.dp, accentCyan.copy(alpha = 0.35f))
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .background(accentCyan, RoundedCornerShape(3.dp))
                )
                Text(
                    text = "SOBERANÍA DIGITAL LIBRE",
                    color = accentCyan,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.8.sp
                )
            }
        }

        Text(
            text = "Escudo Antishadowban",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "Bypass algorítmico y neutralización de filtros",
            fontSize = 13.sp,
            color = Color(0xFF94A3B8)
        )

        // Tarjeta de Entrada
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            border = androidx.compose.foundation.BorderStroke(1.dp, cardBorder)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "✏️ Tu Texto Original",
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFE2E8F0),
                        fontSize = 14.sp
                    )
                    Text(
                        text = "${inputText.length} caracteres",
                        color = Color(0xFF64748B),
                        fontSize = 12.sp,
                        fontFamily = FontFamily.Monospace
                    )
                }

                OutlinedTextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    placeholder = {
                        Text(
                            "Pega aquí tu denuncia, post o texto...",
                            color = Color(0xFF475569),
                            fontSize = 13.sp
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = accentCyan,
                        unfocusedBorderColor = Color(0xFF1E293B),
                        focusedContainerColor = Color(0xFF0A0F1D),
                        unfocusedContainerColor = Color(0xFF0A0F1D)
                    ),
                    shape = RoundedCornerShape(12.dp)
                )

                // Selector de Modos
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf(
                        Triple(AntiShadowbanEngine.Mode.ZWSP, "👻 Zero-Width", "Invisible"),
                        Triple(AntiShadowbanEngine.Mode.HOMOGLYPH, "🪞 Homóglifos", "Gemelos"),
                        Triple(AntiShadowbanEngine.Mode.HYBRID, "🛡️ Blindaje Total", "Híbrido")
                    ).forEach { (mode, title, sub) ->
                        val isSelected = selectedMode == mode
                        Button(
                            onClick = { selectedMode = mode },
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSelected) accentCyan.copy(alpha = 0.15f) else Color(0xFF0A0F1D)
                            ),
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                if (isSelected) accentCyan else Color(0xFF1E293B)
                            ),
                            contentPadding = PaddingValues(4.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = title,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else Color(0xFF94A3B8)
                                )
                                Text(
                                    text = sub,
                                    fontSize = 9.sp,
                                    color = Color(0xFF64748B)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Fila de Botones de Acción
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = {
                    if (inputText.isBlank()) {
                        Toast.makeText(context, "⚠️ Escribe o pega un texto primero", Toast.LENGTH_SHORT).show()
                    } else {
                        val res = AntiShadowbanEngine.process(inputText, selectedMode)
                        outputText = res.text
                        mutationCount = res.mutationCount
                        Toast.makeText(context, "⚡ ¡Texto blindado con éxito!", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7))
            ) {
                Text("⚡ Blindar Texto", fontWeight = FontWeight.Bold, color = Color.White)
            }

            OutlinedButton(
                onClick = {
                    inputText = ""
                    outputText = ""
                    mutationCount = 0
                },
                modifier = Modifier.height(48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFE2E8F0)),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF334155))
            ) {
                Text("🗑️", fontSize = 16.sp)
            }
        }

        // Tarjeta de Salida
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            border = androidx.compose.foundation.BorderStroke(1.dp, cardBorder)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "✨ Texto Blindado (Listo para Redes)",
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFE2E8F0),
                        fontSize = 14.sp
                    )
                    Text(
                        text = "$mutationCount mutaciones",
                        color = accentGreen,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Medium
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .background(Color(0xFF080D1A), RoundedCornerShape(12.dp))
                        .border(1.dp, Color(0xFF1E293B), RoundedCornerShape(12.dp))
                        .padding(12.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    if (outputText.isBlank()) {
                        Text(
                            text = "El resultado aparecerá aquí...",
                            color = Color(0xFF475569),
                            fontSize = 13.sp
                        )
                    } else {
                        Text(
                            text = outputText,
                            color = accentCyan,
                            fontSize = 13.sp,
                            fontFamily = FontFamily.Monospace,
                            lineHeight = 18.sp
                        )
                    }
                }

                Button(
                    onClick = {
                        if (outputText.isNotBlank()) {
                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText("Texto Blindado", outputText)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(context, "📋 ¡Copiado al portapapeles!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "⚠️ No hay texto para copiar", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = accentGreen)
                ) {
                    Text("📋 Copiar al Portapapeles", color = Color(0xFF052E16), fontWeight = FontWeight.Bold)
                }
            }
        }

        Text(
            text = "AndreTaker / BaBaYaga Core — Licencia MIT\n100% Local & Offline • Cero Telemetría",
            color = Color(0xFF475569),
            fontSize = 11.sp,
            lineHeight = 15.sp,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
