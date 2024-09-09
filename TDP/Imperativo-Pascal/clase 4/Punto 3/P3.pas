program P3;

type
    venta = record
        codigoDeVenta:integer;
        CodigoDeProducto:integer;
        cantUnidadesVendidas:integer;
        precioUnitario:integer;
    end;
    lista = ^n2;
    n2 = record
        dato:venta;
        sig:lista;
    end;

    producto = record
        codigoDeProducto:integer;
        cantTotalunidades:integer;
        montoTotal:real;
        ventas :lista;
    end;
    arbol = ^nodo;
    nodo = record
        dato:producto;
        HI:arbol;
        HD:arbol;
    end;

procedure cargarDatos(var L:lista);
begin

    new (L);
    L^.dato.codigoDeVenta:= random(10);
    writeln('ingrese el codigo de venta: ',L^.dato.codigoDeVenta);

    if (L^.dato.codigoDeVenta <> 1) then
    begin
        L^.sig:=nil;

        write('ingrese el codigo del producto: ');
        readln(L^.dato.codigoDeProducto);

        L^.dato.cantUnidadesVendidas:= random(100);
        writeln('ingrese la cantidad de unidades vendidas: ',L^.dato.cantUnidadesVendidas);

        L^.dato.precioUnitario:= random(100);
        writeln('el precio unitario es: ',L^.dato.precioUnitario);
    end
end;

procedure agregarNodoLista(var l:lista; dato:lista);
begin
    dato^.sig:=l;
    l:=dato;
end;

procedure agregar(var a:arbol; L:lista);
begin
    if(a = nil)then
    begin
        new(a);
        a^.dato.codigoDeProducto:=L^.dato.codigoDeProducto;
        a^.dato.cantTotalunidades:=L^.dato.cantUnidadesVendidas;
        a^.dato.montoTotal:=L^.dato.precioUnitario * L^.dato.cantUnidadesVendidas;
        agregarNodoLista(a^.dato.ventas,L);
        a^.HI:=nil;
        a^.HD:=nil;
    end
    else
    begin
        if(L^.dato.codigoDeProducto = a^.dato.codigoDeProducto)then
        begin
            agregarNodoLista(a^.dato.ventas,L);
            a^.dato.cantTotalunidades:= a^.dato.cantTotalunidades + L^.dato.cantUnidadesVendidas;
            a^.dato.montoTotal:=a^.dato.montoTotal +(L^.dato.precioUnitario * L^.dato.cantUnidadesVendidas);
        end
        else
        begin
            if(L^.dato.codigoDeProducto < a^.dato.codigoDeProducto) then
                agregar(a^.HI,L)
            else
                agregar(a^.HD,L);
        end;    
    end;
end;

procedure cargarArbol(var a:arbol);
var
    L:lista;
begin
    a:=nil;
    cargarDatos(L);
    while(L^.dato.codigoDeVenta <> 1)do
    begin
        agregar(a,L);
        L:=nil;
        cargarDatos(L);
    end;
    dispose(L);
end;

procedure imprimirArbol(a:arbol); //imprime los datos generales del arbol
begin
    if(a<>nil)then
    begin
        imprimirArbol(a^.HI);
        writeln('| codigo de Producto: ',a^.dato.codigoDeProducto,' |');
        writeln('| cantidad total de unidades vendidas: ',a^.dato.cantTotalunidades,' |');
        writeln('| Monto Total: ',a^.dato.montoTotal:0:2,' |');
        imprimirArbol(a^.HD);
    end;
end;

function maxUnidadesVendidas(a:arbol;codeMax:integer;uniMax:integer):integer;
begin
    if(a<>nil)then
    begin
        if(a^.dato.cantTotalunidades > uniMax)then
        begin
            codeMax:=a^.dato.codigoDeProducto;
            uniMax:=a^.dato.cantTotalunidades;
        end;
        codeMax:=maxUnidadesVendidas(a^.HI,codeMax,uniMax);
        codeMax:=maxUnidadesVendidas(a^.HD,codeMax,uniMax);
    end;
    maxUnidadesVendidas:=codeMax;
end;
var
    a:arbol;
    codeMax:integer;
    uniMax:integer;
begin
    randomize;
    uniMax:=0;

    cargarArbol(a);
    imprimirArbol(a);

    codeMax:=maxUnidadesVendidas(a,codeMax,uniMax);
    writeln('el codigo con la mayor cantidad de unidades vendidas es: ',codeMax);
    //los procesos d y e se pueden hacer en un mismo recorrido
end.
