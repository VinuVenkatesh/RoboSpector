FROM node:17-alpine as build-step
RUN mkdir -p /home/webApp
WORKDIR /home/webApp
COPY package*.json /home/webApp
RUN npm install
COPY ./ /home/webApp/
RUN npm run build --prod

FROM nginx:1.21
COPY --from=build-step /home/webApp/dist/robotspector_frontend /usr/share/nginx/html
EXPOSE 4200:80