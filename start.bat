@echo off
chcp 65001>nul

setlocal enabledelayedexpansion

echo Mevcut containerlar durduruluyor...
podman compose -f podman-compose.yml down 

set /p arg="Lutfen bir arguman girin: Eger yeni degisiklikler varsa 1, kod hala ayni ise 2 giriniz: "

if "%arg%"=="1" (
    echo Yeni degisiklikler uygulanarak sistem ayaga kaldiriliyor.. lutfen bekleyiniz..
    podman compose -f podman-compose.yml up --build -d 
    echo.
    echo Islem tamamlandi. Port bilgileri cekiliyor, lutfen bekleyiniz...
    goto :check_ports
)

if "%arg%"=="2" (
    echo Sistem ayaga kaldiriliyor.. lutfen bekleyiniz..
    podman compose -f podman-compose.yml up -d 
    echo.
    echo Islem tamamlandi. Port bilgileri cekiliyor, lutfen bekleyiniz...
    goto :check_ports
)

echo Gecersiz arguman. Lutfen 1 veya 2 girin.
pause
exit /b 1

:check_ports
:: Container'larin baslamasi icin bir bekleme suresi (gerekirse ayarlayin)
timeout /t 5 /nobreak >nul

:: Frontend ve backend portlarini dinamik olarak aliyoruz
for /f "tokens=2 delims=:" %%a in ('podman ps --filter "name=frontend" --format "{{.Ports}}"') do (
    for /f "tokens=1 delims=-" %%b in ("%%a") do set FRONTEND_PORT=%%b
)

for /f "tokens=2 delims=:" %%a in ('podman ps --filter "name=gateway" --format "{{.Ports}}"') do (
    for /f "tokens=1 delims=-" %%b in ("%%a") do set BACKEND_PORT=%%b
)


:: Eger portlar bos ise hata ile karsilasmamak icin bir kontrol yapiyoruz
if "%FRONTEND_PORT%"=="" (
    echo Frontend portu bulunamadi.
    exit /b 1
)

if "%BACKEND_PORT%"=="" (
    echo Backend gateway portu bulunamadi.
    exit /b 1
)
:: Port bilgilerini ekrana renkli olarak yazdiriyoruz
powershell -Command "& {Write-Host 'Frontend portu: %FRONTEND_PORT%' -ForegroundColor Red}"
powershell -Command "& {Write-Host 'Backend gateway portu: %BACKEND_PORT%' -ForegroundColor Green}"

powershell -Command "& {Write-Host 'Frontend : http://localhost:%FRONTEND_PORT%' -ForegroundColor Red}"
powershell -Command "& {Write-Host 'Backend : http://localhost:%BACKEND_PORT%/swagger-ui/index.html' -ForegroundColor Green}"

pause
exit /b 0
