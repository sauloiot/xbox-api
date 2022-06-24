docker start idContainer
docker logs --follow  933cfb9290c2

## 4-ms-user
criar o banco
```
docker run --restart unless-stopped -d -p 5432:5432 --name db_xbox --network ms-ghost -e POSTGRES_PASSWORD=1995 -e POSTGRES_DB=db_xbox postgres:latest
```
executar a api no container
```
./sh buildDocker.sh
```

