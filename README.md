# bkn-user


# Database image

$ docker pull postgres:12-alpine
$ docker run -p 5432:5432 --name bkn-user-pg12 --network bkn-net -e POSTGRES_PASSWORD=Famo2369 -e POSTGRES_DB=db_bkn_user postgres:12-alpine