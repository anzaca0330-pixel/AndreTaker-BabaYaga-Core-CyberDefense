from setuptools import setup, find_packages

setup(
    name="babayaga-core",
    version="3.0.0",
    author="Andrea Zabala Cárcamo (AnZaCa)",
    author_email="anzaca0330@gmail.com",
    description="⚡ ANDRETAKER — BaBaYaga Core: Open-Source Cyberdefense Engine, Anti-Palantir Counter-Intelligence & Forensic Suite",
    long_description=open("README.md", encoding="utf-8").read(),
    long_description_content_type="text/markdown",
    url="https://github.com/anzaca0330-pixel/AndreTaker-BabaYaga-Core-CyberDefense",
    packages=find_packages(),
    classifiers=[
        "Programming Language :: Python :: 3",
        "License :: OSI Approved :: Apache Software License",
        "Operating System :: OS Independent",
        "Topic :: Security :: Cryptography",
        "Topic :: Scientific/Engineering :: Information Analysis",
    ],
    python_requires=">=3.8",
)
