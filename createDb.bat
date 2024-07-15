@echo off

REM Muda para o diretório docker
cd docker

REM Inicia o docker-compose
docker-compose up -d

REM Aguarda 3 segundos
timeout /t 3 /nobreak

REM Executa comandos no container mongodb
docker exec -i mongodb bash -c "mongosh --eval \"use Netflix; db.createCollection('Movies'); db.createCollection('Series'); db.createCollection('UserAccounts');\""
