# hackathon-autoharvest

---- WIP ----

Playground for automatic harvesting via .well known endpoint

## Intended workflow:
- Clone this repository
- Start coding!
- Create a new branch, named after your team (?)
- (Optional) Create a pull request towards your branch
- Push your code to the branch

## How do I deploy my code?
- Fix all TODOS in the code
- Push to branch
- That's it! Your code will be deployed automatically

## Something went wrong!
- Check the logs in the Actions tab
- Ask for help in slack

## I need some secrets!
- We'll lump all secrets together in one secret per app in the Hackathon environment
- Create a new issue in this repository, tag it with the "secret" label
- Describe what you need, (i.e. secret name, expected keys)
- Someone will be in touch shortly, if necessary
- Uncomment L16-18 in deploy/hackathon/env.yaml
- Refer to env vars in your code as usual
- A secret should now be available in your app as an environment variable after deployment

## Where do I put my app?
Your code can be placed in the root folder.  
See for example [fdk-statistics-service](https://github.com/Informasjonsforvaltning/fdk-statistics-service)
```
hackathon-autoharvest/
├── .github
│   └── workflows
├── deploy
│   ├── base
│   │   ├── deployment.yaml
│   │   ├── kustomization.yaml
│   │   └── service.yaml
│   └── hackathon
│       ├── env.yaml
│       ├── ingress.yaml
│       └── kustomization.yaml
├── Dockerfile
└── src
```


## What if I have multiple apps?
If you want to deploy multiple apps, place each app in its individual subfolder.  
You will need to do the same with the deploy-subfolders.  
The app names need to be consistent!  
You will also need to uncomment line 20 in .github/workflows/deploy.yaml  
See for example [catalog-frontend](https://github.com/Informasjonsforvaltning/catalog-frontend)
```
hackathon-autoharvest/
├── .github
│   └── workflows
├── app1
│   ├── Dockerfile
│   └── src
├── app2
│   ├── Dockerfile
│   └── src
└── deploy
    ├── base
    │   ├── app1
    │   └── app2
    └── hackathon
        ├── app1
        └── app2
```