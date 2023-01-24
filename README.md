# Tucil 1 Strategi Algoritma

<a href="https://github.com/Fatih20">Fatih Nararya Rashadyfa Ilhamsyah </a>
13521060

## Table of contents

- <a href="#description">Deskripsi</a>
- <a href="#how-to-run">Cara Menjalankan Program</a>
- <a href="#how-to-operate">Petunjuk Penggunaan</a>

<h2 id="description">Deskripsi</h2>
Tugas besar ini adalah program untuk memecahkan permainan 24 menggunakan algoritma <em>brute-force</em>. Berikut adalah <a href="doc/Tucil1_K01_13521060.pdf">file laporan</a>.

<h2 id="how-to-run">Cara Menjalankan Program</h2>

### _Compile_

_Compile_ program :

```bash
sh compile.sh
```

_Compile_ program hanya ke bytecode :

```bash
cd src
javac -d ../bin ./*.java
```

_Compile_ hasil bytecode ke file .jar :

```bash
cd bin
jar -cvfm matrix.jar ../src/META-INF/MANIFEST.MF *
```

### _Run_

File .jar maupun bytecode hasil kompilasi dapat dijalankan.

#### Bytecode

Jalankan bytecode dengan perintah berikut :

```bash
sh run.sh
```

Atau berikut :

```
cd bin
java Main
```

#### File .jar

Jalankan file .jar dengan perintah berikut :

```bash
sh runJar.sh
```

Atau berikut :

```bash
cd bin
java -jar matrix.jar
```

### _Compile and Run_

Program juga dapat di-compile dan langsung di-run hasil kompilasinya menggunakan perintah berikut :

```bash
sh compileAndRun.sh
```

Berguna dalam proses pengembangan yang mengharuskan pengecekan tiap kali ada fungsionalitas baru yang ditambahkan.

<h2 id="how-to-operate">Petunjuk Penggunaan</h2>
Program diasumsikan telah berjalan sesuai cara yang telah dijelaskan di bagian sebelumnya.

1. Masukkan komposisi kartu permainan 24 dengan dipisahkan oleh spasi.
2. Tekan enter.
3. Setelah solusi dan waktu penghitungan solusi muncul, program akan menyimpan solusi ke dalam file yang namanya berasal dari masukan pengguna, jika diminta oleh pengguna. File yang disimpan ada di dalam folder test dengan format txt.
4. Pengguna mendapat opsi untuk bermain lagi atau keluar.
