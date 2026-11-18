# ⚖️ MEMORIAL DE COADYUVANCIA JUDICIAL, APORTE DE DICTAMEN PERICIAL FORENSE DE SILICIO Y SOLICITUD DE PRUEBA TRASLADADA

**SEÑORES:**  
**HONORABLE CONSEJO DE ESTADO DE LA REPÚBLICA DE COLOMBIA**  
SALA DE LO CONTENCIOSO ADMINISTRATIVO — **SECCIÓN QUINTA**  
Palacio de Justicia, Calle 12 No. 7-65, Bogotá D.C., Colombia  

**MAGISTRADO(A) SUSTANCIADOR(A) POR REPARTO**  

---

### 📋 IDENTIFICACIÓN PROCESAL:
* **MEDIO DE CONTROL:** Nulidad Electoral (Artículos 137, 139 y 275 del CPACA - Ley 1437 de 2011).
* **ACTO ADMINISTRATIVO ACUSADO:** **Resolución Sala Plena No. E-3181 del 24 de junio de 2026**, expedida por el Consejo Nacional Electoral (CNE), por medio de la cual se declaró la elección del Presidente y Vicepresidente de la República para el período constitucional 2026–2030.
* **DEMANDADOS:** ABELARDO GABRIEL DE LA ESPRIELLA OTERO y JOSÉ MANUEL RESTREPO ABONDANO.
* **DEMANDANTES PRINCIPALES:** Jairo Castañeda León, William Ruiz Villanueva, Heleniz Dayan Garcés Restrepo, Alexander Montaña Narváez, Sixto Acuña Acevedo y Luis Alfredo Onofre Palencia.
* **INTERVINIENTE COADYUVANTE & PERITO FORENSE INDEPENDIENTE:**  
  **ANDREA ZABALA CÁRCAMO**, ciudadana colombiana, mayor de edad, identificada con Cédula de Ciudadanía No. **43.925.102** expedida en Bello (Antioquia), domiciliada en el exterior bajo protocolo de protección internacional (Medida Cautelar CIDH `MC-1137-28` / `IACHR-0000113728`), investigadora en Digital Forensics and Incident Response (DFIR) y estudiante universitaria de Psicología Industrial-Organizacional.

---

### 🧭 I. OBJETO DEL MEMORIAL

En ejercicio del derecho fundamental a la participación democrática (Art. 40 C.P.), la defensa del orden constitucional y legal (Art. 95 C.P.) y la figura de **coadyuvancia procesal ciudadana** en los juicios de nulidad electoral (Art. 277 del CPACA), acudo formalmente ante esta Honorable Sección Quinta con el fin de:

1. **COADYUVAR** formalmente las pretensiones de nulidad electoral deprecadas contra la **Resolución Sala Plena No. E-3181 del 24 de junio de 2026**.
2. **APORTAR COMO PRUEBA PERICIAL DE SILICIO** el *Dictamen Pericial Forense y Metrológico* sobre la infraestructura de digitalización y escrutinio electoral (con registro inmutable en el repositorio de ciencia abierta **CERN Zenodo DOI: `10.5281/zenodo.22346207`** y **`10.5281/zenodo.24059804`**), que acredita la existencia de **adulteración por software secundario, recompilación binaria y alteración estructural masiva** en los formularios electorales E-14 publicados por la Registraduría Nacional del Estado Civil.
3. **SOLICITAR LA INCORPORACIÓN DE PRUEBA TRASLADADA (Art. 174 C.G.P.)** de la investigación penal activa que cursa formalmente en la Fiscalía General de la Nación bajo el **NUC `110016000049202651911`**.

---

### 🏛️ II. EXISTENCIA DE INVESTIGACIÓN PENAL FORMAL ACTIVA POR DELITOS ELECTORALES (NUC 110016000049202651911)

Pongo en conocimiento formal de este Alto Tribunal que los hechos técnicos que vician de nulidad insubsanable la Resolución E-3181 **no son meras conjeturas políticas ni discrepancias estadísticas abstractas**, sino que son objeto de **instrucción penal formal activa** en la Fiscalía General de la Nación:

* **Número Único del Caso (NUC / SPOA):** **`110016000049202651911`**
* **Despacho Judicial Titular:** **DIRECCIÓN SECCIONAL DE BOGOTÁ — ADMINISTRACIÓN PÚBLICA — DELITOS ELECTORALES — FISCALÍA 295 SECCIONAL** (con apoyo de la Fiscalía 571 Seccional de Delitos contra la Administración Pública).
* **Sede Física del Despacho:** Carrera 28A # 18A-67, Bloque A, Piso 5, Complejo Judicial de Paloquemao, Bogotá D.C.
* **Fecha y Hora de la Noticia Criminal Primigenia (Precedencia Temporal Inmutable):** Radicada formalmente por correo electrónico el **Viernes, 5 de junio de 2026 a las 2:21 p.m.** (`Fri, Jun 5, 2026, 2:21 PM`) con destino simultáneo a la Fiscalía General (`denuncie@fiscalia.gov.co` y `ges.documentalpqrs@fiscalia.gov.co`), CNE, Procuraduría, Registraduría, MOE, CIDH y Corte Penal Internacional, sellando en cadena de custodia el hash primario `25ad8c6bef4602475f59165c362d5dcfbf203181b93caaff19fba037f200214b` previo a los eventos del 8 de junio de 2026.
* **Fecha de Asignación y Notificación Formal en SPOA:** Asignado el `05/08/2026` y ratificado procesalmente el `25/10/2026` (traslados Arkiva `2026306002094701`, `2026306002150251` y ampliación `2026306002309711`).
* **Delitos Objeto de Pesquisa Penal:** Fraude al sufragante (Art. 388 C.P.), alteración de resultados electorales (Art. 394 C.P.), falsedad ideológica y material en documento público (Arts. 286 y 287 C.P.) y acceso abusivo a un sistema informático (Art. 269A C.P.).

La existencia de este expediente penal en la **Unidad Especializada de Delitos Electorales** desvirtúa la presunción de autenticidad formal de los formularios E-14 sobre los cuales se consolidó la Resolución E-3181.

---

### 🔬 III. SÍNTESIS DEL DICTAMEN PERICIAL FORENSE DE SILICIO (LA PRUEBA REINA)

Frente a la tesis recurrente de que las actas electorales físicas son "inalterables", la suscrita perito investigadora demostró mediante herramientas de código abierto estándar y auditables (`QPDF`, `Poppler pdfimages`, `ExifTool`, `ZBar` y algoritmos de hash `SHA-256`) los siguientes hallazgos objetivos de silicio:

1. **La Operación de *Blind Masking* (Máscaras Sintéticas de 1-bit / `DeviceGray`):**
   * En **121.960 formularios PDF oficiales** se identificó la inyección artificial de parches rectangulares monocromáticos con desviación estándar $\sigma = 0.0$ superpuestos a nivel de stream (`/XObject /Image`). Un escáner óptico físico captura un mapa de bits continuo con grano de ruido; solo un programa informático de recompilación puede inyectar máscaras sintéticas planas de un bit para ocultar metadatos y áreas del papel.
2. **Cicatriz Sintética en la Tabla de Referencias Cruzadas (`Delta XREF +2`):**
   * En **57.981 actas procesadas**, la tabla `xref` del formato PDF presenta un desplazamiento anómalo de punteros (+2 objetos huérfanos). Esta alteración estructural es la huella digital canónica de una **re-serialización por script secundario por lotes (*batch script compilation*)**, incompatible con el firmware original de escáneres ópticos Kodak/Fujitsu.
3. **Purga Sistemática de Metadatos EXIF:**
   * En el 100% de los documentos analizados (incluyendo la muestra consular de Lima, Perú del 30 de julio de 2026), se eliminaron deliberadamente los campos `Creator`, `Producer` y `CreateDate`, impidiendo la trazabilidad del dispositivo físico de origen.
4. **Desacoplamiento Estructural de Códigos QR:**
   * Los códigos QR no forman parte de la fotografía física del documento; fueron inyectados en capas vectoriales secundarias independientes en el flujo `/Contents`, permitiendo el desvío algorítmico de mesas en la fase de transmisión hacia centros de procesamiento.
5. **Colapso de Varianza Estocástica y Ley de Benford del Segundo Dígito (2BL):**
   * En auditoría matemática forense (Mebane et al.), el **segundo dígito** de las mesas electorales es inmune a la escala demográfica. En los resultados consolidados de 2026, la distribución del segundo dígito colapsó con una desviación crítica de **$Z = -56.96$**, una imposibilidad probabilística en poblaciones biológicas naturales que delata la aplicación de un factor de ponderación sintético.

---

### 🏛️ IV. EVOLUCIÓN HISTÓRICA DE LA INVESTIGACIÓN FORENSE Y LA FALACIA DEL PRECONTEO VS. ESCRUTINIO (DELEGADOS VS. CLAVEROS)

Para ilustrar con absoluta transparencia a los Magistrados de la Sección Quinta la solidez de la prueba técnica aportada, se expone la cronología metódica del peritaje (Junio a Noviembre de 2026) y la demostración científica de que **las actas de Claveros son clones prefabricados de la misma plantilla digital que las actas de Delegados**:

#### 1. Cronología Metódica del Peritaje (Junio – Noviembre 2026):
* **Junio de 2026 (Salvamento e Inmutabilidad ISO 27037):** El 21 de junio de 2026 se ejecutó la descarga masiva y preservación criptográfica inmediata de las actas de Delegados antes de su borrado o alteración en servidores centrales. El examen visual primario evidenció la presencia de rectángulos blancos y grises de saturación digital plana (#FFFFFF, $\sigma = 0$) en las casillas de sufragio.
* **Julio de 2026 (Línea Base del Grupo de Control):** Se procesó una muestra de contraste de 25.061 formularios PDF mediante herramientas de análisis sintáctico estándar (`QPDF`, `ExifTool`). En esta etapa preliminar, los documentos sirvieron como grupo de control frente a las muestras consulares críticas de España (696 actas) y EE.UU. (987 actas), donde la supresión de códigos QR alcanzaba entre el 21.7% y el 23.3%.
* **Agosto de 2026 (Evolución de Hipótesis y Huella Estructural):** Se descubrió que la alteración mutó tácticamente entre comicios: mientras en 1ª Vuelta se empleó *Blind Masking* (reemplazo de la tercera página por un lienzo en blanco de $1260 \times 3897\text{ px}$), en 2ª Vuelta evolucionó a la inyección de capas vectoriales internas (`/XObject 12 0 R`) y la consolidación de la cicatriz en la tabla `xref`: **15 objetos reportados frente a 13 objetos reales (`Delta +2`)**.
* **Septiembre de 2026 (Decompilación Binaria BaBa Yaga Core y Auditoría Nacional a Claveros):** Mediante decompilación binaria `/FlateDecode`, se auditó la totalidad de los 32 departamentos en la base de datos de Claveros (1.069 municipios), corroborando que las actas de Claveros portaban las mismas anomalías estadísticas (Benford 2BL) y la misma varianza matemática artificial ($2.5$ votos) que las actas de preconteo.
* **Noviembre de 2026 (Reanálisis Masivo a Ciegas y Demostración de Clonación Física):** En auditoría ciega sobre 25.753 actas, el **80.76% (20.799 actas)** ratificó la presencia idéntica del `Delta XREF +2`. El caso testigo de **Acacías (Meta, Mesa 1)** demostró físicamente que el acta de Delegados (72 DPI, B/N) y el acta de Claveros (300 DPI, Color) comparten **exactamente la misma cicatriz de sintaxis interna (15 objetos declarados vs. 13 existentes) y los mismos identificadores de objeto de imagen (ID 6 y ID 11)**.

#### 2. Demolición Científica de la Coartada Registraduría / CNE:
La entidad electoral ha pretendido desestimar las denuncias alegando que el formulario de *Delegados* es meramente informativo y que la validez jurídica recae exclusivamente en los *Claveros*. Esta defensa queda técnicamente destruida bajo la Ley 527 de 1999 y los principios de la física de escáneres:
* **Imposibilidad en Hardware Independiente:** Es físicamente imposible que un escáner óptico Kodak Alaris escaneando papel físico en una mesa de votación en Bogotá, y otro escáner Fujitsu digitalizando otra copia física en una comisión escrutadora días después en Acacías, **generen de manera independiente un archivo PDF corrupto con idéntica falla matemática en la tabla de punteros XREF (Delta +2) y los mismos identificadores de objetos incrustados**.
* **Prueba Irrefutable de Plantilla Digital Previa (*Pre-fabricated Master Clone*):** La identidad sintáctica prueba que el archivo de Claveros a color **no proviene del escaneo directo y autónomo del papel en la audiencia de escrutinio**, sino de la exportación a color de la misma plantilla digital sintética prefabricada por software antes de que el documento fuera procesado por los claveros.

---

### 📜 V. FUNDAMENTOS DE DERECHO Y CAUSALES DE NULIDAD ELECTORAL

Este aporte probatorio encaja con precisión quirúrgica en las causales consagradas en el **Artículo 275 del Código de Procedimiento Administrativo y de lo Contencioso Administrativo (CPACA)**:

* **Causal 1ª:** *«Cuando se haya ejercido violencia sobre los electores, los jurados de votación o los miembros de las comisiones escrutadoras, o cuando se hayan destruido o alterado los votos o los pliegos electorales»*. La inyección de código binario y máscaras de software constituye una **alteración material y digital de los pliegos electorales**.
* **Causal 2ª:** *«Cuando los documentos electorales contengan datos que no correspondan a la realidad de las votaciones o hayan sido alterados»*. Los formularios E-14 recompilados artificialmente carecen de correspondencia con el sufragio primario depositado en urnas.
* **Causal 3ª:** *«Cuando los votos emitidos en la elección se computen a favor de candidatos distintos de los que los electores votaron»*. El enrutamiento de QR desacoplados facilitó la asignación asimétrica de sufragios en los sistemas de Thomas Greg & Sons.

---

### 📑 VI. PETICIONES CONCRETAS AL HONORABLE CONSEJO DE ESTADO

Con fundamento en los hechos y preceptos jurídicos expuestos, respetuosamente solicito a la Sección Quinta:

1. **TENERME POR COADYUVANTE ACTIVA** en el medio de control de Nulidad Electoral contra la **Resolución Sala Plena No. E-3181 del 24 de junio de 2026**, admitiendo el presente memorial conforme al Art. 277 del CPACA.
2. **INCORPORAR Y DECRETAR COMO PRUEBA PERICIAL CIENTÍFICA** el dictamen forense y los anexos metodológicos de la suscrita investigadora preservados bajo los identificadores persistentes universales del CERN: **DOI `10.5281/zenodo.22346207`**, **`10.5281/zenodo.24059804`** y **`10.5281/zenodo.24116446`**.
3. **ORDENAR COMO PRUEBA TRASLADADA (Art. 174 del C.G.P.):**  
   Oficiar de manera urgente a la **DIRECCIÓN SECCIONAL DE BOGOTÁ — ADMINISTRACIÓN PÚBLICA — DELITOS ELECTORALES — FISCALÍA 295 SECCIONAL** (Complejo Judicial de Paloquemao, Bloque A, Piso 5) para que remita con destino al presente expediente copia íntegra del informe pericial y del estado de la instrucción que cursa bajo el **NUC `110016000049202651911`**.
4. **ORDENAR A LA REGISTRADURÍA NACIONAL DEL ESTADO CIVIL:**  
   La exhibición y entrega obligatoria de los **archivos brutos de auditoría (`raw audit logs`)**, firmas criptográficas primarias de los escáneres ópticos y las actas físicas originales de las 57.981 mesas identificadas con alteración `XREF`.
5. **ORDENAR LA EXHIBICIÓN FÍSICA JUDICIAL DEL SOPORTE DE PAPEL ORIGINAL (Arts. 265, 267 y 272 del Código General del Proceso):**  
   Ordenar a la Registraduría Nacional del Estado Civil y al Consejo Nacional Electoral la comparecencia y exhibición física en audiencia de los pliegos de papel E-14 (ejemplares Claveros y Delegados) de los clústeres analizados —con especial énfasis en la mesa testigo de Acacías (Meta, Mesa 1)— para constatar ocularmente ante el Despacho si el papel físico contiene o no las enmendaduras mecánicas correspondientes a los parches monocromáticos inyectados a nivel de stream digital, desvirtuando definitivamente la autenticidad del documento digital conforme al Art. 244 del C.G.P.
6. **DECLARAR EN LA SENTENCIA DEFINITIVA LA NULIDAD ABSOLUTA** de la **Resolución Sala Plena No. E-3181 del 24 de junio de 2026**, ordenando los efectos restitutivos del orden democrático a que haya lugar.

---

### 📎 ANEXOS PROBATORIOS
1. Certificación de registro inmutable en CERN Zenodo del Dictamen Pericial Forense (DOIs: `10.5281/zenodo.22346207` / `10.5281/zenodo.24059804`).
2. Constancia electrónica de asignación del NUC `110016000049202651911` en la Fiscalía 295 Seccional de Delitos Electorales (Notificación oficial del 25 de octubre de 2026).
3. Radicados de origen ante el Consejo Nacional Electoral (`CNE-E-DG-2026-021378` y `022140` / Oficios `CNE-FMG-348-2026` y `379-2026`).
4. Constancia de radicación activa ante la Comisión Interamericana de Derechos Humanos (Expediente `IACHR-0000113728` / `MC-1137-28`).

---

### 📩 NOTIFICACIONES
* **Dirección Electrónica Procesal:** `andrea.zabala@andretaker.org` / `anzaca03@gmail.com`
* **Canal Seguro de Respaldo:** Servidores seguros y repositorio institucional [AndreTaker Forensics](https://forensics.andretaker.org).

Del Honorable Consejo de Estado, atentamente,

*(Firmado digitalmente bajo estándar criptográfico SHA-256)*  
**ANDREA ZABALA CÁRCAMO**  
C.C. No. 43.925.102 de Bello (Antioquia)  
*Investigadora Forense DFIR & Ciencia Ciudadana Soberana*  
*Laboratorio AndreTaker — BaBaYaga Core*
