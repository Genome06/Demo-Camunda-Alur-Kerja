# DemoCamundaAlurKerja
DemoCamundaAlurkerja adalah sebuah project yang digunakan dalam keperluan workshop yang diselenggarakan oleh PT. Javan Cipta Solusi. 
Proyek ini bertujuan untuk membantu para peserta memahami dan juga mengetahui caranya mengimplementasi kan library 
AlurKerja dalam mengirim notifikasi via telegram maupun email dan juga membuat tampilan dalam sebuah project camunda tasklist.

## Instalasi Lokal
Untuk menjalankan proyek ini di lingkungan lokal Anda, ikuti langkah-langkah berikut:

1. Clone Repository
```xml
git clone link_repository
cd repository
```

2. Buat File Konfigurasi
   Salin file konfigurasi contoh dan sesuaikan dengan informasi lokal Anda

```xml
cp application.yaml.example application.yaml
```

3. Create Database
   Buat database baru di postgresql dengan nama sesuai yang diinginkan

4. Sesuaikan Credential Edit file
   Edit file application.yaml dan sesuaikan dengan credential nya dengan credential di lokal anda.

5. Sesuaiakan credential application.yaml
   Sesuaikan credential yang digunakan dalam application.yaml dengan credential yang ada di lokal anda. 
   Contohnya credential database dan juga telegram bot.
6. Jalankan Aplikasi
```xml
mvn spring-boot:run
```