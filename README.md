Coverage: 11%
# IMS Project

This is an inventory management system that offers CRUD functionality for 3 entities within the system - Customers, Orders, and the Items within these orders.
It is a CLI app. Individuals can also use the app to add and delete items from orders.
[Jira](https://d-mac.atlassian.net/jira/software/projects/SCFPS/boards/3/roadmap) was used as project management software for this project.

## Getting Started

If you wish to develop the software, fork into your own Git Repository and work from there.
If you wish to run the app, download the code .zip file and open in a new folder.

### Prerequisites

You will need an IDE, preferably VSCode, IntelliJ, or Eclipse.
VSCode can be downloaded [here](https://code.visualstudio.com/download).
Eclipse can be downloaded [here](https://www.eclipse.org/downloads/).
IntelliJ can be downloaded [here](https://www.jetbrains.com/idea/download/#section=mac).
I recommend using the Community version of IntelliJ.

You will also need Maven installed. The pom.xml file provided should have adequate dependencies.
Should you want more, visit [Maven Repository](https://mvnrepository.com).

VSCode has a plugin for Maven [here](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven).
A helpful tutorial for the installation and integration of Maven into Eclipse can be found [here](https://www.vogella.com/tutorials/EclipseMaven/article.html).

IntelliJ has Maven pre-installed. 
When creating a new project simply select Maven as the build tool you'd like to use.


### Installing

Download the zip from this repo.

## Running the tests

I would generally wipe and re-run the SQL schema for each test.
The DBUtils class does not seem to be able to close the connection after each.
It therefore uses existing data and messes up the tests.
In future I may make these read the most recent ID to make the tests more dynamic.

### Unit Tests 

Integration testing has not been properly implemented across this programme due to time constraints and crunch fatigue.

### Integration Tests 

Integration testing has not been properly implemented across this programme due to time constraints and crunch fatigue.

## Deployment

On a live system simply run the executable file by calling in your console. Mac may require a port before running.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Dejan McCreery** - *Project* - [dejanmccreery](https://github.com/dejanmccreery)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* The folks at [QACTrainers](https://github.com/QACTrainers) who wrote the IMS-Starter class this app is based on.
* StackOverflow for helping me and sending me down unimaginably useless rabbit holes (I learnt a lot though).
* Morgan Walsh at QAC for teaching us and pushing through the heat. 
* And for just being an all around great guy.
* Andy Gray for taking us through the basics.
* Christopher Yiangou for coming in clutch when Morgan had emergencies/was ill.
