var radio=4;
var name: string = 'Steve';
name='';
var decirHola:(nombre:string) =>string;
decirHola=function(nombre:string){

    return 'hola '+nombre;
};

interface Persona{
    nombre:string;
    altura:number;
}
var persona:Persona={
nombre:'Juan Carlos',
altura:168
}

console.log('hola como estas'+persona.nombre);