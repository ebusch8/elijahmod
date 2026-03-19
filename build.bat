@echo off
echo ==========================================
echo Building ElijahMod...
echo ==========================================
call gradlew build

if %errorlevel% neq 0 (
    echo Build failed. Fix errors and try again.
    pause
    exit /b %errorlevel%
)

echo.
echo ==========================================
echo Starting Minecraft Forge Client...
echo ==========================================
call gradlew runClient

pause
