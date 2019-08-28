# team-krypton
---

Table of Contents

- [Description](#description)
- [Risk Graph](#risk)
- [How To Use](#how-to-use)
- [Architecture](#architecture)
- [Authors](#authors)

---
## Description

Application for ease of retrieving information from a data set stored in CSV format.

Designed around the following three scenerios:

Suspect has been detained; may need need to know : Biographical information, Associates, Financial transactions, Whereabouts.

An incident has occured: Need to work out who was in the area at a particular point in time.

Suspect flees the scene: Who was the suspect? Where have they been?

---


## Architecture
![Architecture](/Docs/Architecture.png)

Front-End: React

APP: Node, Port:9000

Audit: SpringBoot, Port:9002

Citizen: SpringBoot, Port: 9003

Call Records: SpringBoot, Port: 9004

ANPR: SpringBoot, Port 9005

Transactions: SpringBoot, Port 9006

Epos: SpringBoot, Port: 9008

ATM: SpringBoot, Port: 9009

---
## Sequence Diagrams
![Architecture](/Docs/LoginSequence.png)

### Project Planning

## Technologies Used
- Mongo - Database
- Node - APP and User microservices 
- SpringBoot - 
- React - Front - End Development 
- Jenkins - CI Server
- Git - Version Control System
- Jira - Project Planning tool
- GCP - Live Enviroment
- Docker - Compose - to build all containers at once from images stored



## Risk Graph

To forecast issues likely to occur during the 2.5 week project and allocate time for potential issues we used a Risk Graph.

Tolerate - "Ignore" i.e. Situations were out of our control.

Treat - "Come up with a solution" i.e. situations that can be improved and made less of a threat to our progress.

Terminate - "Situations that need immediate attention" - need to be dealt with early on to prevent issues down the line.


Examples of some of the issues we identified are:

* Knowledge	- Knowledge limited to technologies covered in academy - Treat
* Internet	- Internet service issues at QA, unable to reach cloud services - Tolerate
* Communication - 	Poor communication will lead to poor project end result - Treat
* Planning	- Not completing tasks to customer specification - Treat
* New Technologies -	New software being utilised with scope, limited knowledge - Treat
* Docker - Issues	Issues with configuration delay progress - Treat
* Unknown Unknowns - Tolerate

## How To Use
### Set up
* GCP/Azure account
* Log in and open new cloud shell

#### Installation


az configure --defaults location=uksouth

## Create a new resource group 
az group create --name myResourceGroup

## Create a VM
az vm create --resource-group myResourceGroup --name vmName --image UbuntuLTS --generate-ssh-keys

## Installing docker
sudo apt update

sudo apt install docker.io -y

sudo usermod -aG docker $(whoami)

## Installing docker-compose on Linux
Next install docker-compose on your manager VM.
```
sudo curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose
```


cd ~
git clone https://github.com/hbuck95/team-krypton.git
cd team-krypton
docker-compose build




---


## Authors

- Harry
- James
- Krystal
- Jack
- Tania 

## Acknowledgements
* QA consulting and our amazing instructors.
* The Product Owners for their advice.













