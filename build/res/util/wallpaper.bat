@echo off
reg add "hkcu\control panel\desktop" /v "wallpaper" /d "%1" /f  
