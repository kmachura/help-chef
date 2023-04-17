FROM node:18.16.0

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY help-chef/package*.json ./

RUN npm install --save-dev

COPY . .

RUN npm run build

EXPOSE 4200

CMD ["npm", "start"]