#!/bin/bash

cd docker

docker-compose up -d

sleep 3

docker exec -i mongodb bash <<EOF
mongosh <<EOM
use Netflix
db.createCollection('Movies')
db.createCollection('Series')
db.createCollection('UserAccounts')
EOM
EOF

