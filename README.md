Create the DataStore indexed defined in our index.yaml
gcloud datastore indexes create indexes/index.yaml

Cleanup any indexes on DataStore not used anymore
gcloud datastore indexes cleanup indexes/index.yaml

Build and Deploy Docker container
gcloud builds submit --tag gcr.io/PROJECT-ID/rectool-service

Deploy to Cloud Run
gcloud run deploy --image gcr.io/PROJECT-ID/rectool-service --platform managed

GraphQL UI can be accessed through
https://rectool-service-.../graphiql