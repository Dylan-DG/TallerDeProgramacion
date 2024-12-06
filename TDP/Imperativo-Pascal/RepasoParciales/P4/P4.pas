program p4;

type
    Dia= 1..30;

    envio = record
        codCli:integer;
        dia:Dia;
        pesoPaquete:real;
    end;
    EnviosRecibidos = record
        codPostal:integer;
        envio:envio;
    end;

    lista = ^n;
    n = record
        dato:envio;
        sig:lista;
    end;

    dato = record
        codPostal:integer;
        envios:lista;
    end;
    arbol = ^nodo;
    nodo = record
        dato:dato;
        HI:arbol;
        HD:arbol;
    end;

procedure imprimir(a:arbol);
begin
    if(a <> nil)then
    begin
        writeln(a^.dato.codPostal);
        imprimir(a^.HI);
        imprimir(a^.HD);
    end
end;

procedure leerEnvio(var e:EnviosRecibidos);
begin
    e.envio.codCli:=random(10);
    if(e.envio.codCli <> 0) then
    begin
        e.envio.dia:=random(30);
        e.envio.pesoPaquete:=random(100);
        write('codigo postal: ');
        readln(e.codPostal);
    end;
end;

procedure agregarLista(var l:lista; e:envio);
var 
    aux:lista;
begin
    new(aux);
    aux^.dato:=e;
    aux^.sig:=l;
    l:=aux;
end;

procedure agregar(var a:arbol; e:EnviosRecibidos);
var
    aux:arbol;
begin
    if(a = nil)then
    begin
        new(aux);
        aux^.dato.codPostal:=e.codPostal;
        agregarLista(aux^.dato.envios,e.envio);
        aux^.HI:=nil;
        aux^.HD:=nil;
        a:=aux;
    end
    else
    begin
        if(e.codPostal = a^.dato.codPostal)then
            agregarLista(a^.dato.envios,e.envio)
        else if(e.codPostal < a^.dato.codPostal)then
            agregar(a^.HI,e)
        else
            agregar(a^.HD,e);
    end;
end;

procedure crearArbol(var a:arbol);
var
    envio:EnviosRecibidos;
begin
    leerEnvio(envio);
    while(envio.envio.codCli <> 0)do
    begin
        agregar(a,envio);
        leerEnvio(envio);
    end;
end;
function traerEnvios(a:arbol; postal:integer):lista;
begin
    if(a = nil)then
        traerEnvios:=nil
    else    
    begin
        if(a^.dato.codPostal = postal)then
            traerEnvios:=a^.dato.envios
        else if(postal< a^.dato.codPostal)then
            traerEnvios:=traerEnvios(a^.HI,postal)
        else
            traerEnvios:=traerEnvios(a^.HD,postal);
    end;
end;
procedure imprimirCodigos(l:lista);
begin
    if(l <> nil)then
    begin
        write(l^.dato.codCli,'peso: ');
        writeln(l^.dato.pesoPaquete:0:2);
        imprimirCodigos(l^.sig);
    end;
end;
procedure maximos(l:lista; var codMin,codMax:integer;var maxPeso,MinPeso:real);
begin
    if(l <> nil)then
    begin
        if(MinPeso>l^.dato.pesoPaquete)then
        begin
            codMin:=l^.dato.codCli;
            MinPeso:=l^.dato.pesoPaquete;
        end
        if(maxPeso<l^.dato.pesoPaquete)then
        begin
            codMax:=l^.dato.codCli;
            maxPeso:=l^.dato.pesoPaquete;
        end;
        maximos(l^.sig,codMin,codMax,maxPeso,MinPeso);
    end;        
end;

var
    a:arbol;
    postal:integer;
    envios:lista;
    codMin,codMax:integer;
    maxPeso,MinPeso:real;
begin
    maxPeso:=-1;
    MinPeso:=1000;
    Randomize;
    a:=nil;
    crearArbol(a);
    //imprimir(a);
    write('ingresa un codigo postal a buscar: ');
    readln(postal);
    envios:=traerEnvios(a,postal); //punto b
    //writeln('CODIGOS');
    //imprimirCodigos(envios);
    maximos(envios,codMin,codMax,maxPeso,MinPeso);//punto c
    writeln('el minimo es: ',codMin);
    writeln('el maximos es: ',codMax);
end.