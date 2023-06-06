FROM node:18.16.0

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install --save-dev @angular/cli@latest -g

RUN npm install

COPY . .

RUN npm run

EXPOSE 4200

CMD ["npm", "start"]
