program P3;
const
    notaMax=10;
    diasMax=30;
    mesesMax=12;
type
    nota=1..notaMax;
    dia=1..diasMax;
    mes=1..mesesMax;

    fecha = record
        dia:dia;
        mes:mes;
    end;
    finales = record
        codigoMateria:integer;
        fecha:fecha; //tambien podria hacerse con un simple string pero me gusta mas asi xd
        nota:nota;
    end;
    lista = ^nodo2;
    nodo2 = record
        dato2:finales;
        sig:lista;
    end;


    alumno = record
        legajo:integer; // de esta forma todos los parciales quedan bajo un legajo
        final:lista; //aca estaria la lista de todos los finales
    end;
    arbol =  ^nodo;
    nodo = record
        dato:alumno;
        HI:arbol;
        HD:arbol;
    end;

procedure cargarDatos(var dato:alumno);
begin
    randomize;
    write('ingrese el legajo del alumno: ');
    readln(dato.legajo);

    if (dato.legajo <> 0) then
    begin
        new(dato.final);

        dato.final^.dato2.codigoMateria:= random(101);
        writeln('ingrese el codigo de la materia: ',dato.final^.dato2.codigoMateria);

        dato.final^.dato2.fecha.dia := random(diasMax) +1;
        dato.final^.dato2.fecha.mes := random(mesesMax) +1;
        writeln('ingrese la fecha del final: ',dato.final^.dato2.fecha.dia,'/',dato.final^.dato2.fecha.mes);

        dato.final^.dato2.nota := random(notaMax) +1;
        writeln('ingrese la nota del final: ',dato.final^.dato2.nota);
    end;
end;

procedure AgregarNodoLista(var L:lista; dato:lista); //este proceso va agregando nodos a las listas de los alumnos
begin
    if(L=nil)then
    begin
        L:=dato;
        dato:=nil;
    end
    else
    begin
        dato^.sig:=L;
        L:=dato;
        dato:=nil;
    end;
end;

procedure agregar(var a:arbol;dato:alumno);
begin
    if(a=nil)then
    begin
        new(a);
        a^.dato.legajo:=dato.legajo;
        AgregarNodoLista(a^.dato.final,dato.final);
        a^.HI:=nil;
        a^.HD:=nil;
    end
    else
    begin
        if(dato.legajo = a^.dato.legajo)then
            AgregarNodoLista(a^.dato.final,dato.final)
        else
        begin
            if(dato.legajo < a^.dato.legajo)then
                agregar(a^.HI,dato)
            else
                agregar(a^.HD,dato);
        end;
    end;
end;

procedure cargarArbol(var a:arbol);
var
    dato:alumno;
begin
    cargarDatos(dato);
    while(dato.legajo <>0)do
    begin
        agregar(a,dato);
        cargarDatos(dato);
    end;
end;

function cantLegajoImpares(a:arbol;impar:integer):integer; //devuelve la cantidad de alumnos con legajos impares
begin
    if(a<>nil)then
    begin
        if(a^.dato.legajo mod 2 <> 0)then
            impar:=impar +1;
        impar:= cantLegajoImpares(a^.HI,impar);
        impar:= cantLegajoImpares(a^.HD,impar);
    end;
    cantLegajoImpares:=impar;
end;

procedure cantFinalesAprobados(a:arbol); //devuelve la cantidad de finales aprobados por cada alumno
    procedure recorreLista(L:lista;var cantAprobados:integer);
    begin
        if(L<>nil)then
        begin
            if(L^.dato2.nota >=4)then
                cantAprobados:=cantAprobados+1;
            recorreLista(L^.sig,cantAprobados);
        end;
    end;
var
    cantAprobados:integer;
begin
    cantAprobados:=0;
    if(a <> nil)then
    begin
        recorreLista(a^.dato.final,cantAprobados);
        writeln('------------------------------------');
        writeln('| legajo: ',a^.dato.legajo,' | Finales Aprobados: ',cantAprobados,' |');
        cantFinalesAprobados(a^.HI);
        cantFinalesAprobados(a^.HD);
    end;
end;

//el modulo para retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado lo dejare ya que es mas de lo mismo

var
    a:arbol;
    impar:integer;
begin
    impar:=0;

    cargarArbol(a);
    impar:=cantLegajoImpares(a,impar);
    writeln('la cantidad de alumnos con legajos impares es: ',impar);

    cantFinalesAprobados(a);
end.