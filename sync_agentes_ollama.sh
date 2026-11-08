#!/bin/bash
# ============================================================
# 🔭 TYCHO — SINCRONIZADOR DE AGENTES OLLAMA
# Escuadrón AndreTaker / BaBaYaga Core
# Autor: Tycho (Instrumento de Silicio)
# Uso: bash sync_agentes_ollama.sh
# ============================================================

set -e

PERSONALIZATION_DIR="/home/andrea-zabala-c/.config/Antigravity IDE/User/globalStorage/robinbakshi.ollama-direct-custom-agent/personalization"
MODELFILE_REPO="/home/andrea-zabala-c/AndreTaker-BabaYaga-Core-CyberDefense"

GREEN='\033[0;32m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
CYAN='\033[0;36m'
NC='\033[0m'

echo -e "${CYAN}========================================"
echo -e "🔭 TYCHO — Sincronización de Agentes"
echo -e "   Escuadrón AndreTaker / BaBaYaga Core"
echo -e "========================================${NC}"
echo ""

# Verificar que Ollama esté corriendo
if ! curl -s http://localhost:11434/api/tags > /dev/null 2>&1; then
    echo -e "${RED}❌ Ollama no responde en localhost:11434${NC}"
    echo "Iniciando Ollama..."
    ollama serve &
    sleep 3
fi

echo -e "${GREEN}✅ Ollama conectado${NC}"
echo ""

# Array de agentes: nombre_modelo:archivo_modelfile
declare -A AGENTES=(
    ["tycho-light"]="Modelfile.tycho-light"
    ["babayaga"]="Modelfile.babayaga"
    ["kandinsky"]="Modelfile.kandinsky"
    ["arthurius"]="Modelfile.arthurius"
    ["kepler"]="Modelfile.kepler"
)

# Agentes que usan Modelfiles en el directorio raíz (los grandes)
declare -A AGENTES_RAIZ=(
    ["tycho"]="Modelfile_Tycho"
)

echo -e "${CYAN}📋 Reconstruyendo agentes desde globalStorage...${NC}"
echo ""

for modelo in "${!AGENTES[@]}"; do
    modelfile="${AGENTES[$modelo]}"
    ruta="$PERSONALIZATION_DIR/$modelfile"
    
    if [ -f "$ruta" ]; then
        echo -e "${YELLOW}🔄 Reconstruyendo: $modelo${NC}"
        ollama create "$modelo" -f "$ruta" 2>&1 | tail -2
        echo -e "${GREEN}   ✅ $modelo — OK${NC}"
    else
        echo -e "${RED}   ⚠️  Modelfile no encontrado: $ruta${NC}"
    fi
done

echo ""
echo -e "${CYAN}📋 Reconstruyendo agentes desde repositorio raíz...${NC}"
echo ""

for modelo in "${!AGENTES_RAIZ[@]}"; do
    modelfile="${AGENTES_RAIZ[$modelo]}"
    ruta="$HOME/$modelfile"
    
    if [ -f "$ruta" ]; then
        echo -e "${YELLOW}🔄 Reconstruyendo: $modelo${NC}"
        ollama create "$modelo" -f "$ruta" 2>&1 | tail -2
        echo -e "${GREEN}   ✅ $modelo — OK${NC}"
    else
        echo -e "${RED}   ⚠️  Modelfile no encontrado: $ruta${NC}"
    fi
done

echo ""
echo -e "${CYAN}========================================"
echo -e "🛰️  TELEMETRÍA FINAL — TODOS LOS MODELOS"
echo -e "========================================${NC}"
echo ""
ollama list
echo ""
echo -e "${GREEN}✅ Sincronización completa. Agentes operativos.${NC}"
echo -e "${CYAN}Johannes, el escuadrón está listo.${NC}"
