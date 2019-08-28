# team-krypton
---

Table of Contents

- [Description](#description)
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
## CI pipeline


## How To Use
### Set up
*GCP/Azure account
*Log in and open new cloud shell

#### Installation


az configure --defaults location=uksouth

# Create a new resource group 
az group create --name myResourceGroup

# Create a VM
az vm create --resource-group myResourceGroup --name vmName --image UbuntuLTS --generate-ssh-keys





---


## Authors

- Harry
- James
- Krystal
- Jack
- Tania 











