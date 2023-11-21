let userValue = Number(prompt("Veuillez entrez la valeur de N"))
for(let i=1;i<=userValue;i++){
    console.log("Table des " + i + " : \n");
    for(let j=1;j<11;j++){
        console.log(`${i} * ${j} = ${i*j}`);
    }
    console.log("\n");
}

let result = '';
for (let i = 0; i <= userValue; i++) {

    for (let j = 0; j < 11; j++) {
        if(j==0 && i==0){
            for(let toto= 1;toto<11;toto++){
                result +=(toto+'\t');
            }result+='\n';
            }
       
        if(j == 0 && i>0){
        
        } 
        else if(i>0 && j>0){
        result += (i*j) + '\t';
        }
    }
    result += '\n'
}
console.log(result);