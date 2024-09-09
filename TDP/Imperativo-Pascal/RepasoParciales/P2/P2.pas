program p2;
const
    mesesMax=12;
type
    mes = 1..mesesMax;
    atencion= record    
        matricula:integer;
        dni:integer;
        mes:mes;
        diagnostico:char;
    end;
    dato = record
        dni:integer;
        codigo:char;
    end;    

    arbol = ^nodo;
    nodo = record
        dato:dato;
        hi:arbol;
        hd:arbol;
    end;
    vector = array[1..mesesMax] of arbol;

procedure leerAtencion(var v:atencion);
var
    a: array[1..5] of char = ('L','M','N','O','P');
begin
    v.matricula:=random(1000);
    if(v.matricula <>0)then
    begin
        v.dni:=random(5000)+1000;
        v.mes:=random(mesesMax)+1;
        v.diagnostico:=a[random(5)+1];
    end;
end;

procedure agregar(var a:arbol;dato:atencion);
begin
    if(a =nil)then
    begin
        new(a);
        a^.dato.dni:=dato.dni;
        a^.dato.codigo:=dato.diagnostico;
        a^.hi:=nil;
        a^.hd:=nil;
    end
    else
    begin
        if(a^.dato.dni < dato.dni)then
            agregar(a^.hi,dato)
        else
            agregar(a^.hd,dato);
        
    end;
end;

procedure cargarVector(var v:vector);
var
    dato:atencion;
begin
    leerAtencion(dato);
    while(dato.matricula <>0)do
    begin
        agregar(v[dato.mes],dato);
        leerAtencion(dato);
    end;
end;

procedure recorrerArbol(a:arbol;var cant:integer);
begin
    if(a<>nil)then
    begin
        cant:=cant +1;
        recorrerArbol(a^.hi,cant);
        recorrerArbol(a^.hd,cant);
    end;
end;

procedure recorrer2(a:arbol;var ok:boolean;dni:integer);
begin
    if(a<>nil) and (ok<> true)then
    begin
        if(dni = a^.dato.dni)then
            ok:=true;
        if(dni<a^.dato.dni)then
            recorrer2(a^.hi,ok,dni)
        else
            recorrer2(a^.hd,ok,dni);
    end;
end;

procedure recorrerVector(v:vector;var mesMax:integer; cantMax:integer;dimL:integer);
var
    cant:integer;
begin
    if(dimL <> 0)then
    begin
        cant:=0;
        recorrerArbol(v[dimL],cant);
        if(cant> cantMax)then
        begin
            mesMax:=dimL;
            cantMax:=cant;
        end;
        recorrerVector(v,mesMax,cantMax,dimL-1);
    end;
end;

procedure buscar(v:vector;var ok:boolean;dimL:integer;dni:integer);
begin
    if(dimL <> 0) and (ok<> true)then
    begin
        recorrer2(v[dimL],ok,dni);
        buscar(v,ok,dimL-1,dni);
    end;
end;

var 
    v:vector;
    cantMax:integer;
    mesMax:integer;
    ok:boolean;
    dni:integer;
begin
    cantMax:=0;
    randomize;
    ok:=false;

    cargarVector(v);
    recorrerVector(v,mesMax,cantMax,mesesMax);
    read(dni);
    buscar(v,ok,mesesMax,dni);
    writeln('el paciente fue atendido?: ',ok);
end.
