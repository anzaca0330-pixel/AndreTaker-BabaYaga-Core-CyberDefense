# PROTOCOLO DE EMERGENCIA DFIR (NIVEL 0): DESCONTAMINACIÓN DE BOOTKIT / ROOTKIT UEFI, KERNEL LINUX Y HARDWARE MÓVIL

![DFIR Level 0](https://img.shields.io/badge/DFIR-Level_0_Bare_Metal_Sanitization-red.svg)
![OS](https://img.shields.io/badge/Target-Linux_Kernel_%7C_UEFI_BIOS_%7C_Android-blue.svg)
![ISO 27037](https://img.shields.io/badge/ISO%2FIEC-27037_Compliant-teal.svg)
![License](https://img.shields.io/badge/License-MIT_%2F_Apache_2.0-green.svg)

**Autora e Investigadora Principal:** Andrea Zabala Cárcamo (AnZaCa / AndreTaker)  
**Ecosistema:** AndreTaker — BaBaYaga Core CyberDefense (`www.andretaker.org`)  
**Clasificación:** Procedimiento Pericial de Descontaminación Física en Frío (*Bare-Metal Sanitization*)  
**Fecha del Incidente Original y Forja en Campo:** 8 al 29 de junio de 2026 (20 días de aislamiento bajo asedio cibernético)  
**Fecha de Consolidación y Publicación Oficial:** 7 de noviembre de 2026  

---

## 📜 1. REGISTRO CRONOLÓGICO Y EVIDENCIA DE CAMPO (JUNIO – JULIO 2026)

Este protocolo no es un ejercicio teórico de laboratorio. Fue diseñado, probado y ejecutado en condiciones reales de supervivencia informática durante el asedio contra la investigadora principal tras la radicación de los hallazgos periciales sobre las actas electorales E-14 (>677 GB, 777.869 archivos sellados bajo SHA-256 con el apoyo de 75.000 Testigos Digitales).

| Fecha Certificada | Hito Técnico / Incidente Forense | Referencia / Verificación Documental |
| :--- | :--- | :--- |
| **31 Mayo – 6 Junio 2026** | Recolección masiva y descubrimiento de inyección vectorial (*1-Bit Blind Masking* y desfasaje XREF $+2$) en actas E-14. | Bóveda Criptográfica SHA-256 (>147.000 documentos). |
| **8 Junio 2026** | **Ataque de Rootkit / Bootkit UEFI en BIOS (ThinkPad):** Sabotaje a nivel de firmware. Deshabilitación de energía al bus USB y bloqueo de controladores host PCI/SATA en *early-boot* para impedir el arranque de memorias USB de rescate. | Rescate de evidencia mediante esteganografía de sistema de archivos y reflasheo en frío. |
| **10 Junio 2026** | **Persistencia tras Factory Wipe:** Verificación empírica de que el restablecimiento convencional no elimina implantes alojados en particiones de arranque o firmware. | Adquisición de equipo aislado en T-Mobile y contención de cuenta de rescate interceptada. |
| **13 – 20 Junio 2026** | **Sabotaje Físico/Vehicular y Vector OBD-II:** Emboscada en carretera (13 de junio, 11:01 PM) e inspección técnica en taller especializado Mitsubishi (20 de junio) con aislamiento del vector físico OBD-II (FIXD). | `Incident C20260617-0024-01` (Buckingham County Sheriff, VA) y registros certificados T-Mobile. |
| **Pos-20 Junio 2026** | **Certificación Oficial de Fabricante (Lenovo):** Soporte técnico de Lenovo emite radicado oficial confirmando inoperatividad y bloqueo de hardware/BIOS por infección de Rootkit/Bootkit en portátil ThinkPad. | Ticket Oficial Lenovo (`Key Ref: [TICKET-LENOVO-REDACTED]`). |
| **15 – 28 Junio 2026** | **Aislamiento Físico (Jaula de Faraday) y Comparecencia ante el FBI:** Contención electromagnética de dispositivos comprometidos y entrega presencial de evidencia en la sede del FBI (Richmond, VA) y reporte IC3. | Comparecencia presencial FBI Richmond / Reporte IC3. |
| **29 Junio 2026** | **Solicitud de Medidas Cautelares ante la CIDH (OEA):** Radicación formal del expediente técnico y de derechos humanos. | Radicado Oficial **`IACHR - 0000113728`**. |

---

## ⚠️ 2. PRINCIPIO FUNDAMENTAL FORENSE (POR QUÉ FALLA EL FORMATEO COMÚN)

> **UN RESTABLECIMIENTO DE FÁBRICA O REINSTALACIÓN ESTÁNDAR NO ELIMINA UN BOOTKIT O ROOTKIT DE FIRMWARE.**

En una arquitectura moderna (sea un computador con Linux/Windows bajo UEFI o un dispositivo móvil Android), el sistema operativo que el usuario ve es apenas el último piso de un edificio. Debajo existen sótanos invisibles:
1. **Chip SPI Flash / EEPROM (UEFI / BIOS):** Se ejecuta antes que el disco duro.
2. **Sectores de Arranque y Particiones EFI (`ESP`, `MBR`, `GPT`, `/boot`):** Cargan el núcleo del sistema.
3. **Anillo Cero (`Ring 0` / Linux Kernel Modules - LKM):** Donde los rootkits interceptan llamadas del sistema (`syscalls`) para esconder sus propios archivos y procesos.

Cuando un atacante infecta estas capas bajas, formatear la partición de usuario (`/home` o `/data`) es como barrer la sala mientras el intruso sigue escondido en el sótano con copia de las llaves. La única remediación científicamente válida es la **Sanitización Física desde el Nivel Cero (Bare-Metal Reflash & Zero-Fill)**.

---

## 💻 3. COMPUTADOR PC / LAPTOP CON LINUX (UEFI BOOTKIT & KERNEL ROOTKIT)

### Fase A: Aislamiento Inmediato y Diagnóstico en Vivo (Antes de Apagar)
Si sospechas que tu estación Linux ha sufrido una escalada de privilegios (LPE) o inyección de un rootkit de kernel (LKM):

1. **Corte Físico de Red (Air-Gap):** Desconecta el cable Ethernet, apaga el interruptor físico de Wi-Fi/Bluetooth o aísla el equipo.
2. **Auditoría Rápida de Módulos de Kernel y Llamadas Ocultas (Desde un binario estático confiable o Live USB limpio):**
   ```bash
   # 1. Verificar si el kernel reporta banderas de contaminación (Tainted Kernel)
   cat /proc/sys/kernel/tainted

   # 2. Listar módulos cargados y buscar discrepancias con /sys/module
   lsmod
   diff <(lsmod | awk '{print $1}' | sort) <(ls /sys/module | sort)

   # 3. Inspeccionar variables efivars (UEFI) en busca de entradas de arranque no autorizadas
   efibootmgr -v

   # 4. Verificar reglas udev manipuladas (usadas para bloquear puertos USB/SATA de rescate)
   ls -la /etc/udev/rules.d/ /lib/udev/rules.d/
   ```

### Fase B: Reflasheo de Firmware UEFI/BIOS en Frío (SPI Flash / EEPROM)
1. **Desde una máquina 100% limpia y verificada**, descarga la imagen oficial del BIOS/UEFI desde el portal del fabricante (Lenovo, Dell, ASUS, HP, etc.) y verifica su suma criptográfica `SHA-256`.
2. Prepara una unidad USB nueva formateada en `FAT32`.
3. Utiliza el mecanismo de **actualización en frío por hardware** antes de que cargue cualquier sistema operativo:
   - **BIOS FlashBack / Crisis Recovery Mode:** Inserta el USB en el puerto dedicado con el equipo apagado y presiona el botón físico de FlashBack (sobrescribe el chip EEPROM directamente sin encender el procesador principal).
   - **Utilidad Interna UEFI (Lenovo BIOS Flash / EZ-Flash / Q-Flash):** Entra con `F1`/`F2`/`Supr` en el encendido en frío y fuerza el reflasheo completo de todas las regiones del firmware, incluyendo el *Boot Block*.
4. En el menú UEFI recién flasheado:
   - Activa **Secure Boot** en modo estricto y **restablece las llaves de fábrica (Factory Keys: PK, KEK, db, dbx)**.
   - Deshabilita **Wake-on-LAN**, **Intel AMT / vPro** (gestión remota fuera de banda) y el arranque por red (**PXE Boot**).

### Fase C: Destrucción Quirúrgica del Sector de Arranque (Zero-Fill MBR / GPT / EFI)
Los bootkits suelen alojarse en la partición del sistema EFI (`ESP`) o en los primeros megabytes del disco NVMe/SSD. Para aniquilarlos:

1. Arranca el computador usando un **Live USB de Linux (Debian/Ubuntu/Arch)** grabado desde otra máquina limpia.
2. Abre una terminal y ejecuta el barrido criptográfico de los sectores de arranque y de todo el disco:
   ```bash
   # Identificar el disco físico (ej. /dev/nvme0n1 o /dev/sda)
   lsblk

   # PASO 1: Destruir tablas de particiones GPT/MBR primarias y secundarias
   sudo sgdisk --zap-all /dev/nvme0n1

   # PASO 2: Sobrescribir con ceros los primeros 500 MB (donde residen MBR, GPT y la partición EFI/Bootkit)
   sudo dd if=/dev/zero of=/dev/nvme0n1 bs=1M count=500 status=progress && sync

   # PASO 3 (Recomendado para SSD/NVMe): Purga física de celdas de memoria (NVMe Secure Erase / blkdiscard)
   sudo blkdiscard -f /dev/nvme0n1
   ```
3. Reinstala tu distribución Linux desde cero activando **cifrado completo de disco (`LUKS2`)** para que nadie pueda modificar `/boot` o el sistema de archivos en reposo.

---

## 📱 4. DISPOSITIVOS MÓVILES ANDROID (DESCONTAMINACIÓN DE PARTICIONES FÍSICAS)

### A. Dispositivos Samsung (Protocolo Odin / Heimdall con Re-Particionado PIT)
1. **Descarga de Firmware Limpio Oficial (Sin intermediarios):**
   ```bash
   pip install samloader
   samloader -m SM-MODELO -r CSC download -O .
   samloader -m SM-MODELO -r CSC decrypt -v VERSION -i ARCHIVO.enc4 -o firmware_limpio.zip
   ```
2. **Modo Download:** Apaga el teléfono por completo. Mantén presionados `Bajar Volumen + Subir Volumen` y conecta el cable USB al PC limpio. Presiona `Subir Volumen` una vez.
3. **Flasheo en Linux Nativo mediante `Heimdall` (Sobrescritura con Tabla PIT):**
   ```bash
   sudo heimdall detect
   sudo heimdall flash --resume --PIT s1.pit \
     --BOOTLOADER sboot.bin \
     --PARAM param.bin \
     --BOOT boot.img \
     --RECOVERY recovery.img \
     --SYSTEM system.img \
     --USERDATA userdata.img \
     --CACHE cache.img \
     --RADIO modem.bin
   ```
   *(En Windows con Odin v3.14+: carga `BL`, `AP`, `CP` y obligatoriamente **`CSC`** regular — **NUNCA uses `HOME_CSC`**, ya que `CSC` reconstruye la tabla física de particiones PIT y destruye cualquier persistencia).*

### B. Dispositivos Motorola / Google Pixel / Xiaomi (Fastboot Total Wipe)
1. Descarga la imagen de fábrica completa (**Fastboot ROM `.tgz` / Factory Image**, no el paquete OTA de actualización).
2. Inicia el teléfono en **Modo Fastboot** (`Bajar Volumen + Encendido`).
3. Ejecuta el barrido total de ambos slots (`Slot A` y `Slot B`):
   ```bash
   # En Google Pixel (o vía https://flash.android.com en navegador Brave):
   fastboot flashing unlock
   ./flash-all.sh   # Sobrescribe bootloader, radio y todas las particiones de sistema
   fastboot flashing lock   # Restaura el Android Verified Boot (AVB) criptográfico
   ```
   *(En Xiaomi/Redmi: ejecuta `./flash_all.sh` en Linux. Jamás utilices `flash_all_except_storage.sh`).*

---

## 🛡️ 5. REGLAS DE ORO POST-DESCONTAMINACIÓN (HIGIENE PERIMETRAL)

1. ❌ **CERO RESTAURACIÓN DE BACKUPS EJECUTABLES:** Jamás restaures copias de seguridad completas del sistema o de aplicaciones. Restaura únicamente archivos de datos planos (documentos `.pdf`, `.csv`, imágenes o texto) previamente verificados con `sha256sum`.
2. 🔑 **ROTACIÓN TOTAL DE CREDENCIALES DESDE ENTORNO LIMPIO:** Cambia todas tus contraseñas y revoca tokens de sesión activos (OAuth / API Keys) únicamente desde el equipo recién reflasheado.
3. 🧭 **NAVEGACIÓN Y CONECTIVIDAD BLINDADA:** Utiliza **Brave Browser** (con escudos estrictos contra *fingerprinting*) y túneles anónimos auditados como **Mullvad VPN** (basados en numeración criptográfica sin correo electrónico).
4. 🔒 **BLOQUEO DE BOOTLOADER Y SECURE BOOT:** Verifica que el *Bootloader* quede cerrado (`Locked`) y *Secure Boot* activo para que cualquier intento futuro de alterar un solo byte del kernel impida el arranque y te alerte de inmediato.

---

### 📚 Citación Académica y Pericial (CERN / Zenodo / GitHub)
> **Zabala Cárcamo, A.** (2026). *Protocolo de Emergencia DFIR (Nivel 0): Descontaminación de Bootkit / Rootkit UEFI, Kernel Linux y Hardware Móvil*. AndreTaker — BaBaYaga Core CyberDefense. Disponible en: `https://www.andretaker.org` y `https://github.com/anzaca0330-pixel/AndreTaker-BabaYaga-Core-CyberDefense`
