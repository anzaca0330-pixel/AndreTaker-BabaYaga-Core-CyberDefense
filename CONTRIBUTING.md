# CONTRIBUTING TO ANDRETAKER & BABAYAGA CORE

Thank you for your interest in contributing to the **AndreTaker / BaBaYaga Core** open-source digital forensics and defensive security ecosystem. 

Our mission is to build robust, reproducible, and verifiable tools for human rights defenders, independent auditors, and forensic researchers worldwide.

---

### 1. GUIDING ETHICAL PRINCIPLES (DEFENSIVE MANDATE)
* **100% Defensive Security:** We do not accept contributions that introduce offensive capabilities, unauthorized surveillance mechanisms, or exploit payloads.
* **Cryptographic Immutability:** Any code touching evidence processing must guarantee that the original dataset is strictly **read-only** and that SHA-256 hashes are calculated and verified at ingestion.
* **Reproducibility & Standards:** All forensic algorithms must adhere to **ISO/IEC 27037:2012** (Digital Evidence Handling) and produce deterministic, reproducible outputs.

---

### 2. CODE OF CONDUCT
By participating in this project, you agree to abide by our [Code of Conduct](CODE_OF_CONDUCT.md). We maintain a respectful, welcoming, and scientifically rigorous community.

---

### 3. DEVELOPMENT WORKFLOW

#### A. Getting Started
1. Fork the repository on GitHub.
2. Clone your fork locally:
   ```bash
   git clone https://github.com/your-username/AndreTaker-BabaYaga-Core-CyberDefense.git
   cd AndreTaker-BabaYaga-Core-CyberDefense
   ```
3. Create a dedicated feature or fix branch:
   ```bash
   git checkout -b feature/modular-benford-optimizer
   ```

#### B. Architectural Standards
* **Python Code:** Follow PEP 8 guidelines. All forensic modules must include docstrings detailing inputs, outputs, and cryptographic assertions.
* **Testing:** Run existing test suites before submitting:
   ```bash
   python3 -m unittest discover -s BABAYAGA_CORE/tests
   ```
* **No Hardcoded Credentials or Personal Identifiers:** Ensure all test cases use **synthetic data** (`tests/samples/synthetic_sample.pdf`) and never real private data.

---

### 4. SUBMITTING PULL REQUESTS (PR)

1. **Keep PRs Focused:** Submit small, self-contained PRs addressing a single feature, bug fix, or documentation enhancement.
2. **Include Tests:** Any new forensic parser, mathematical metric, or file decoder must include corresponding unit tests with synthetic fixtures.
3. **PR Description Format:**
   * **Summary of changes:** Clear explanation of what was added or modified.
   * **Motivation & Context:** What problem does this solve?
   * **Forensic Verification:** Commands run to verify deterministic output.
4. **Sign-off:** Include a `Signed-off-by: Developer Name <developer@example.com>` in your commits (Developer Certificate of Origin).

---

### 5. TRANSLATIONS & DOCUMENTATION (ES / EN / FR)
We actively seek contributors to help maintain our tri-lingual documentation architecture:
* Spanish (Official Primary Case Documentation)
* English (International Legal & Technical Standards)
* French (Diplomatic & International NGO Formats)

To contribute translations, submit PRs targeting the respective language directories (`ES_ESPANOL/`, `EN_ENGLISH/`, `FR_FRANCAIS/`).
