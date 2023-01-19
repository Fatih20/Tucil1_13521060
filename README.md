# Tucil 1 Strategi Algoritma [13521060]

## Table of contents

- <a href="#description">Deskripsi</a>
- <a href="#how-to-run">Cara Menggunakan Program</a>

<h2 id="description">Deskripsi</h2>
Tugas besar ini adalah program untuk memecahkan permainan 24 menggunakan algoritma <em>brute-force</em>. Berikut adalah <a href="doc/Algeo01-13521045.pdf">file laporan</a>.

<h2 id="how-to-run">Cara Menggunakan Program</h2>

### _Compile_

_Compile_ program Java bisa dilakukan dengan cara:

```bash
sh compile.sh
```

Atau, untuk _compile_ program ke bytecode saja di folder bin bisa dengan:

```bash
cd src
javac -d ../bin ./*.java
```

Lalu, untuk _compile_ hasil bytecode ke file .jar di folder bin bisa dengan:

```bash
cd bin
jar -cvfm matrix.jar ../src/META-INF/MANIFEST.MF *
```

### _Run_

Untuk menjalankan program yang telah di-_compile_, bisa dengan menjalankan file .jar ataupun bytecode.

#### Bytecode

Untuk menjalankan program dari bytecode bisa dengan:

```bash
sh run.sh
```

Atau

```
cd bin
java Main
```

#### File .jar

Sedangkan untuk menjalankan program dari file .jar bisa dengan:

```bash
sh runJar.sh
```

atau

```bash
cd bin
java -jar matrix.jar
```
