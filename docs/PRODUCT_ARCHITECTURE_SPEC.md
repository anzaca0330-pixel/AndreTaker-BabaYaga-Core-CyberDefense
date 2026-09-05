# ESPECIFICACIÓN ARQUITECTÓNICA Y PLAN MODULAR DEL ECOSISTEMA
## AndreTaker Umbrella System: Core, Forensics, Security & Education

**Coordinación de Arquitectura:** Johannes (AnZaCa), Tycho & Kepler  
**Versión:** 1.1.0-EXPANDED  
**Fecha:** Septiembre 2026  
**Estándar de Cadena de Custodia:** ISO/IEC 27037:2012  

---

### 1. VISIÓN GENERAL DE LA ARQUITECTURA

El ecosistema **AndreTaker** se estructura formalmente como una organización paraguas (*Umbrella Organization*) compuesta por cuatro pilares modulares sinérgicos:

```text
┌─────────────────────────────────────────────────────────────────────────────────────────┐
│                                 ORGANIZACIÓN ANDRETAKER                                 │
│                               (andretaker.org / Gateway)                                │
└────────────────────────────────────────────┬────────────────────────────────────────────┘
                                             │
       ┌─────────────────────────────────────┼─────────────────────────────────────┐
       ▼                                     ▼                                     ▼
┌─────────────────────────────┐┌─────────────────────────────┐┌─────────────────────────────┐
│    andretaker-forensics     ││     andretaker-security     ││     andretaker-academy      │
│       (BaBaYaga Core)       ││     (Defensive Shield)      ││    (Educación & Gamified)   │
├─────────────────────────────┤├─────────────────────────────┤├─────────────────────────────┤
│ • Ingesta masiva y scraping ││ • Blindaje de endpoints     ││ • Juego "Guardianes         │
│ • Decompilación /FlateDecode││ • Auditoría perimetral y RF ││   Digitales" (Táctico/RPG)  │
│ • Motor Benford 2BL         ││ • Detección spyware / keylog││ • Laboratorios didácticos   │
│ • Expedientes legales CIDH  ││ • Protocolo Anti-Palantir   ││ • Guías ciudadanas y peritos│
└──────────────┬──────────────┘└──────────────┬──────────────┘└──────────────┬──────────────┘
               │                              │                              │
               └──────────────────────────────┼──────────────────────────────┘
                                              ▼
                               ┌─────────────────────────────┐
                               │       andretaker-core       │
                               │(Biblioteca Compartida Libre)│
                               ├─────────────────────────────┤
                               │ • Hashes SHA-256 inmutables │
                               │ • Logs estructurados ISO    │
                               │ • Custodia ISO/IEC 27037    │
                               │ • Modelos y abstracción I/O │
                               └─────────────────────────────┘
```

---

### 2. DEFINICIÓN DETALLADA DE PRODUCTOS

#### A. `andretaker-core` (La Base Criptográfica)
* **Propósito:** Proveer las primitivas matemáticas y utilidades base compartidas por todas las herramientas del ecosistema.
* **Componentes clave:**
  * `crypto_engine.py`: Motor centralizado de cálculo y verificación de hashes SHA-256 y HMAC.
  * `custody_logger.py`: Bitácora inmutable con marcas de tiempo (RFC 3161 / ISO 27037).
  * `storage_adapter.py`: Capa de abstracción para lectura en solo-lectura (*Cold Case Isolation*).

#### B. `andretaker-forensics` (BaBaYaga Core - El Bisturí Pericial)
* **Propósito:** Análisis forense masivo de documentos, detección de alteraciones sintéticas y generación de evidencia reproducible para cortes internacionales.
* **Fuentes de evidencia soportadas:**
  * Archivos PDF (estructuras de objetos `/Catalog`, `/Pages`, `/Contents`, `/XObject`).
  * Tablas de datos crudos (CSV, SQLite, JSON).
  * Registros de telecomunicaciones (Facturas detalladas, CDRs, metadatos de llamadas Wi-Fi).
* **Formatos de salida:**
  1. *Pericial / Técnico:* Logs crudos, volcados JSON y matrices de deltas XREF.
  2. *Jurídico / Legal:* Dossiers formales listos para radicar ante CIDH, jueces y fiscalías.
  3. *Ciudadano:* Visualizaciones claras y resúmenes ejecutivos.

#### C. `andretaker-security` (Defensive Shield - El Escudo)
* **Propósito:** Contrainteligencia digital, protección perimetral del investigador y monitoreo de canales fuera de banda.
* **Directriz Mandatoria:** **100% Defensa Autorizada.** No contiene exploits, no realiza escaneos agresivos contra terceros y rechaza cualquier vector ofensivo ilícito.
* **Módulos:**
  * Monitoreo perimetral y detección de saturación de balizas (*Beacon Flood Watch*).
  * Verificación de interfaces locales y aislamiento de puertos.
  * Protección de identidad y ofuscación de metadatos sensibles (*Entity Redaction*).

#### D. `andretaker-academy` / Pedagogía Pericial (El Brazo Educativo & Lúdico)
* **Propósito:** Democratizar el conocimiento en ciberseguridad, alfabetización digital y auditoría forense mediante interfaces interactivas, narrativas inmersivas y gamificación táctica.
* **Componentes clave:**
  1. 🎮 **"Guardianes Digitales" (Juego Táctico de Ciberdefensa):**
     * Experiencia lúdica donde los usuarios aprenden principios de DFIR, detección de phishing, protección de llaves criptográficas y defensa de bóvedas digitales junto a *Arthurius (11 años), Chris, Tobias el perrito y el escuadrón*.
     * Dinámicas de rol (RPG de ciberseguridad) para entrenar a jóvenes, periodistas y activistas en ambientes seguros y sin frustración técnica.
  2. 🧪 **Laboratorios Prácticos con Datos Sintéticos (*Synthetic Forensics Sandbox*):**
     * Muestras de actas y archivos PDF simulados para que estudiantes y auditores aprendan a detectar inyecciones de capas vectoriales (`1bpc`) y desfasajes XREF paso a paso sin comprometer datos reales.
  3. 📚 **Guías Didácticas Tri-Nivel:**
     * Materiales educativos graduados: desde explicaciones sin tecnicismos para el **Ciudadano Común**, pasando por manuales de litigio para **Abogados/Jueces**, hasta guías avanzadas de ingeniería inversa para **Peritos DFIR**.

---

### 3. ESTRATEGIA DE REPOSITORIOS Y EMPAQUETADO

* **Fase 1 (Actual - Monorepo Transicional):**
  * Mantener el repositorio actual organizado internamente con las carpetas `core/`, `forensics/`, `security/`, `academy/` y `docs/`.
* **Fase 2 (Desacoplamiento Modular):**
  * Creación de la organización de GitHub `AndreTaker-Org`.
  * Publicación del paquete base en PyPI (`pip install andretaker-core`).
  * Lanzamiento de binarios independientes compilados (AppImage / Standalone para Linux, macOS y Windows).
  * Despliegue de la plataforma interactiva web en `andretaker.org/academy`.

---

### 4. GOBERNANZA Y CRITERIOS DE ADMISIBILIDAD JUDICIAL
Todo entregable generado por `andretaker-forensics` cumplirá con los 4 principios de Daubert/ISO 27037:
1. **Replicabilidad:** Cualquier auditor con el script y la muestra obtendrá el mismo hash exacto.
2. **Revisión por Pares (*Peer-Review Ready*):** Algoritmos y matemáticas documentados y públicos.
3. **Tasa de Error Conocida:** Umbrales de significancia estadística explícitos ($p < 0.0001$).
4. **Cadena de Custodia:** Registro ininterrumpido desde el scraping inicial hasta la exportación legal.
