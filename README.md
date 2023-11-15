
# Challenge Android

This project is created entirely with Kotlin.

<div align="center"><p align="center"><a href="https://github.com/JimenezR"><img src="assets/challenge.png" width="150"></a></p></div>

## Screenshots

-- in progress ...

## Project Structure

The project structure consider layers of Clean Architecture with MVVM, in this way we have next main packages:

- **app:** application

- **domain:** business entities and business rules

- **data:** repository pattern, use business entities and business rules

- **presentation:** where we have screens, flows (that use use cases) and implementations of data sources

For more information visit this URL: https://developer.android.com/topic/architecture

##  Gradle Configuration

The project is divided into 2 environments

### Enviroments

- **production:** this environment is used for production deployments

- **develop:** this environment is used by developers

## Getting Started

First, clone the repo:

```bash
    git@github.com:JimenezR/Challenge.git
```

Next, you will to have add in the local.properties this code:

```bash
    SONAR_HOST_URL=SONAR_HOST_URL
    SONAR_TOKEN=SONAR_TOKEN
    SONAR_PROJECT_NAME=SONAR_PROJECT_NAME
    SONAR_PROJECT_KEY=SONAR_PROJECT_KEY
```

## Documentation

- [GitHub](https://github.com/JimenezR/Challenge)
- in progress ...

## Acknowledgements

- [Git](https://git-scm.com)
- [GitHub](https://github.com)
- [Detekt](https://detekt.dev)
- [JaCoCo](https://www.jacoco.org)
- [SonarQube](https://www.sonarqube.org)
- [Ktlint](https://ktlint.github.io)
- [SonarQube](https://www.sonarqube.org)
- in progress ...

## Contributing

- [Rodolfo Jimenez](https://github.com/JimenezR)

For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
