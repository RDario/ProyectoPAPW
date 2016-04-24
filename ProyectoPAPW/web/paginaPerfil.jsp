<%-- 
    Document   : paginaPerfil
    Created on : 23/04/2016, 04:22:15 PM
    Author     : Dario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Galaxy Music</title>
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <h1><a href="#">Galaxy Music</a></h1>
                </div>

                <div id="miPerfil">
                    <a href="paginaLogin.jsp"> Iniciar sesión </a>
                    <a href="paginaCrearCuenta.jsp"> Crear Cuenta </a>
                    <a href="pagCarritoDeCompras.html"> Mi Carrito </a>
                </div>

                <div id="search">
                    <form method="get" action="">
                        <fieldset>
                            <input type="text" name="s" id="search-text" size="15" placeholder="Buscar..." />
                            <input type="submit" id="search-submit" value="buscar" />
                        </fieldset>
                    </form>
                </div>
            </div>
            <div id="menu">
                <ul>
                    <li class="current_page_item"><a href="#">Inicio</a></li>
                    <li><a href="#">Música</a></li>
                    <li><a href="#">Audio libros</a></li>
                    <li><a href="#">Listas de reproducción</a></li>
                    <li><a href="#">Contacto</a></li>
                </ul>
            </div>

            <div id="page">
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="content">
                            <div class="post">
                                <h3>Mi Perfil</h3>
                                <form id="form-perfil" action="" method="post" autocomplete="off">
                                    <div id="divArriba">
                                        <div id="contenedorDatosPersonales">
                                            <img src="images/Logo.jpg" width="143" height="143" alt="" class="alignleft border" />
                                            <input name="nickname" type="text" id="lblNickname" placeholder="Miklovish" autofocus="" required=""></p>

                                                <input name="nombreusuario" type="text" id="lblUsuario" placeholder="Dario Valdes" autofocus="" required=""></p>

                                                    <input name="email" type="text" id="lblemail" placeholder="ruben_miklo@hotmail.com" required=""></p>
                                                        </div>

                                                        <div id="contenedorDatosPersonalesDos">
                                                            <input name="contrasenia" type="password" id="lblcontrasenia" placeholder="********" required=""></p>

                                                                <select name="listaanios">
                                                                    <option selected value="-1"> Elige un año</option>
                                                                    <option value="0">1920</option>
                                                                    <option value="1">1921</option>
                                                                    <option value="2">1922</option>
                                                                    <option value="3">1923</option>
                                                                    <option value="4">1924</option>
                                                                    <option value="5">1925</option>
                                                                    <option value="6">1926</option>
                                                                    <option value="7">1927</option>
                                                                    <option value="8">1928</option>
                                                                    <option value="9">1929</option>
                                                                    <option value="10">1930</option>
                                                                    <option value="11">1931</option>
                                                                    <option value="12">1932</option>
                                                                    <option value="13">1933</option>
                                                                    <option value="14">1934</option>
                                                                    <option value="15">1935</option>
                                                                    <option value="16">1936</option>
                                                                    <option value="17">1937</option>
                                                                    <option value="18">1938</option>
                                                                    <option value="19">1939</option>
                                                                    <option value="20">1940</option>
                                                                    <option value="21">1941</option>
                                                                    <option value="22">1942</option>
                                                                    <option value="23">1943</option>
                                                                    <option value="24">1944</option>
                                                                    <option value="25">1945</option>
                                                                    <option value="26">1946</option>
                                                                    <option value="27">1947</option>
                                                                    <option value="28">1948</option>
                                                                    <option value="29">1949</option>
                                                                    <option value="30">1950</option>
                                                                    <option value="31">1951</option>
                                                                    <option value="32">1952</option>
                                                                    <option value="33">1953</option>
                                                                    <option value="34">1954</option>
                                                                    <option value="35">1955</option>
                                                                    <option value="36">1956</option>
                                                                    <option value="37">1957</option>
                                                                    <option value="38">1958</option>
                                                                    <option value="39">1959</option>
                                                                    <option value="40">1960</option>
                                                                    <option value="41">1961</option>
                                                                    <option value="42">1962</option>
                                                                    <option value="43">1963</option>
                                                                    <option value="44">1964</option>
                                                                    <option value="45">1965</option>
                                                                    <option value="46">1966</option>
                                                                    <option value="47">1967</option>
                                                                    <option value="48">1968</option>
                                                                    <option value="49">1969</option>
                                                                    <option value="50">1970</option>
                                                                    <option value="51">1971</option>
                                                                    <option value="52">1972</option>
                                                                    <option value="53">1973</option>
                                                                    <option value="54">1974</option>
                                                                    <option value="55">1975</option>
                                                                    <option value="56">1976</option>
                                                                    <option value="57">1977</option>
                                                                    <option value="58">1978</option>
                                                                    <option value="59">1979</option>
                                                                    <option value="60">1980</option>
                                                                    <option value="61">1981</option>
                                                                    <option value="62">1982</option>
                                                                    <option value="63">1983</option>
                                                                    <option value="64">1984</option>
                                                                    <option value="65">1985</option>
                                                                    <option value="66">1986</option>
                                                                    <option value="67">1987</option>
                                                                    <option value="68">1988</option>
                                                                    <option value="69">1989</option>
                                                                    <option value="70">1990</option>
                                                                    <option value="71">1991</option>
                                                                    <option value="72">1992</option>
                                                                    <option value="73">1993</option>
                                                                    <option value="74">1994</option>
                                                                    <option value="75">1995</option>
                                                                    <option value="76">1996</option>
                                                                    <option value="77">1997</option>
                                                                    <option value="78">1998</option>
                                                                    <option value="79">1999</option>
                                                                    <option value="80">2000</option>
                                                                    <option value="81">2001</option>
                                                                    <option value="82">2002</option>
                                                                    <option value="83">2003</option>
                                                                    <option value="84">2004</option>
                                                                    <option value="85">2005</option>
                                                                    <option value="86">2006</option>
                                                                    <option value="87">2007</option>
                                                                    <option value="88">2008</option>
                                                                    <option value="89">2009</option>
                                                                    <option value="90">2010</option>
                                                                    <option value="91">2011</option>
                                                                    <option value="92">2012</option>
                                                                    <option value="93">2013</option>
                                                                    <option value="94">2014</option>
                                                                    <option value="95">2015</option>
                                                                    <option value="96">2016</option>
                                                                </select>

                                                                <select name="listameses">
                                                                    <option value="0">Enero</option>
                                                                    <option value="1">Febrero</option>
                                                                    <option value="2">Marzo</option>
                                                                    <option value="3">Abril</option>
                                                                    <option value="4">Mayo</option>
                                                                    <option value="5">Junio</option>
                                                                    <option value="6">Julio</option>
                                                                    <option value="7">Agosto</option>
                                                                    <option value="8">Septiembre</option>
                                                                    <option value="9">Octubre</option>
                                                                    <option value="10">Noviembre</option>
                                                                    <option value="11">Diciembre</option>
                                                                </select>

                                                                <select name="listadias">
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="5">5</option>
                                                                    <option value="6">6</option>
                                                                    <option value="7">7</option>
                                                                    <option value="8">8</option>
                                                                    <option value="9">9</option>
                                                                    <option value="10">10</option>
                                                                    <option value="11">11</option>
                                                                    <option value="12">12</option>
                                                                    <option value="13">13</option>
                                                                    <option value="14">14</option>
                                                                    <option value="15">15</option>
                                                                    <option value="16">16</option>
                                                                    <option value="17">17</option>
                                                                    <option value="18">18</option>
                                                                    <option value="19">19</option>
                                                                    <option value="20">20</option>
                                                                    <option value="21">21</option>
                                                                    <option value="22">22</option>
                                                                    <option value="23">23</option>
                                                                    <option value="24">24</option>
                                                                    <option value="25">25</option>
                                                                    <option value="26">26</option>
                                                                    <option value="27">27</option>
                                                                    <option value="28">28</option>
                                                                    <option value="29">29</option>
                                                                    <option value="30">30</option>
                                                                    <option value="31">31</option>
                                                                </select>
                                                        </div>
                                                        </div>
                                                        </br>
                                                        <p id="bActualizar"><input type="submit" id="btnActualizar" name="submit" value="Guardar" class="boton"></p>
                                                        </form>
                                                        </div>
                                                        </div>

                                                        <div id="sidebar">
                                                            <h3>Dirección Personal</h3>
                                                            <div id="contenedorDatosDireccion">
                                                                <input name="calle" type="text" id="lblCalle" placeholder="Santa Eugenia #5597" autofocus="" required=""></p>

                                                                    <input name="colonia" type="text" id="lblColonia" placeholder="Riberas de la Purisima" autofocus="" required=""></p>

                                                                        <input name="codigopostal" type="text" id="lblCodigoPostal" placeholder="67129" autofocus="" required=""></p>
                                                                            </div>

                                                                            <div id="contenedorDatosDireccionDos">
                                                                                <select name="listapaises">
                                                                                    <option value="0">México</option>
                                                                                </select>

                                                                                <select>
                                                                                    <option value="1">Aguascalientes</option>
                                                                                    <option value="2">Baja California</option>
                                                                                    <option value="3">Baja California Sur</option>
                                                                                    <option value="4">Campeche</option>
                                                                                    <option value="5">Chiapas</option>
                                                                                    <option value="6">Chihuahua</option>
                                                                                    <option value="7">Coahuila</option>
                                                                                    <option value="8">Colima</option>
                                                                                    <option value="9">Ciudad de Mexico</option>
                                                                                    <option value="10">Durango</option>
                                                                                    <option value="11">Estado de México</option>
                                                                                    <option value="12">Guanajuato</option>
                                                                                    <option value="13">Guerrero</option>
                                                                                    <option value="14">Hidalgo</option>
                                                                                    <option value="15">Jalisco</option>
                                                                                    <option value="16">Michoacán</option>
                                                                                    <option value="17">Morelos</option>
                                                                                    <option value="18">Nayarit</option>
                                                                                    <option value="19">Nuevo León</option>
                                                                                    <option value="20">Oaxaca</option>
                                                                                    <option value="21">Puebla</option>
                                                                                    <option value="22">Querétaro</option>
                                                                                    <option value="23">Quintana Roo</option>
                                                                                    <option value="24">San Luis Potosí</option>
                                                                                    <option value="25">Sinaloa</option>
                                                                                    <option value="26">Sonora</option>
                                                                                    <option value="27">Tabasco</option>
                                                                                    <option value="28">Tamaulipas</option>
                                                                                    <option value="29">Tlaxcala</option>
                                                                                    <option value="30">Vereacruz</option>
                                                                                    <option value="31">Yucatán</option>
                                                                                    <option value="32">Zacatecas</option>
                                                                                </select>

                                                                                <select>
                                                                                    <option value="1">Aguascalientes</option>
                                                                                    <option value="2">Tijuana</option>
                                                                                    <option value="3">La Paz</option>
                                                                                    <option value="4">Campeche</option>
                                                                                    <option value="5">Tuxtla Gutierrez</option>
                                                                                    <option value="6">Chihuahua</option>
                                                                                    <option value="7">Saltillo</option>
                                                                                    <option value="8">Colima</option>
                                                                                    <option value="9">Ciudad de Mexico</option>
                                                                                    <option value="10">Durango</option>
                                                                                    <option value="11">Izcalli</option>
                                                                                    <option value="12">Guanajuato</option>
                                                                                    <option value="13">Iguala</option>
                                                                                    <option value="14">Hidalgo</option>
                                                                                    <option value="15">Guadalajara</option>
                                                                                    <option value="16">Michoacán</option>
                                                                                    <option value="17">Cuatla</option>
                                                                                    <option value="18">Tepic</option>
                                                                                    <option value="19">Monterrey</option>
                                                                                    <option value="20">Oaxaca</option>
                                                                                    <option value="21">Puebla</option>
                                                                                    <option value="22">Querétaro</option>
                                                                                    <option value="23">Cancún</option>
                                                                                    <option value="24">Ciudad Valles</option>
                                                                                    <option value="25">Los Mochis</option>
                                                                                    <option value="26">Hermosillo</option>
                                                                                    <option value="27">Tabasco</option>
                                                                                    <option value="28">Tampico</option>
                                                                                    <option value="29">Tlaxcala</option>
                                                                                    <option value="30">Boca del Río</option>
                                                                                    <option value="31">Yucatán</option>
                                                                                    <option value="32">Jerez</option>
                                                                                </select>
                                                                            </div>
                                                                            </div>
                                                                            <div style="clear: both;">&nbsp;</div>
                                                                            <div id="contentCarritoDeCompras">
                                                                                <h3>Ver mis listas de produccion</h3>
                                                                                <input type="submit" id="btnActualizar" name="submit" value="Ver mis listas" class="boton">
                                                                                    <br>
                                                                                        <br>
                                                                                            <h3>Ver mis grabaciones</h3>
                                                                                            <input type="submit" id="btnActualizar" name="submit" value="Ver mis listas" class="boton">
                                                                                                <br>
                                                                                                    <br>
                                                                                                        <br>
                                                                                                            <h3>Reporte de ventas</h3>
                                                                                                            <br>
                                                                                                                <br>
                                                                                                                    <table style="border-style: groove;">
                                                                                                                        <tr>
                                                                                                                            <th>Autor</th>
                                                                                                                            <th>Categoria</th>
                                                                                                                            <th>Titulo</th>
                                                                                                                            <th>Fecha de compra</th>
                                                                                                                            <th>Precio</th>
                                                                                                                            <th>Impuestos</th>
                                                                                                                            <th>Email comprador</th>
                                                                                                                            <th>Domicilio comprador</th>
                                                                                                                            <th>RFC comprador</th>
                                                                                                                            <th>CURP comprador</th>
                                                                                                                            <th>Medio de pago</th>
                                                                                                                            <th>Ultimos 4 digitos</th>
                                                                                                                        </tr>
                                                                                                                        <tr>
                                                                                                                            <th>Radiohead</th>
                                                                                                                            <th>Musica</th>
                                                                                                                            <th>Album The King Of Limbs</th>
                                                                                                                            <th>19-02-2016</th>
                                                                                                                            <th>350.00 MXN</th>
                                                                                                                            <th>69.00 MXN</th>
                                                                                                                            <th>diego.goonie@hotmail.com</th>
                                                                                                                            <th>Ajonjoli #3755 Anahuac</th>
                                                                                                                            <th>192378238</th>
                                                                                                                            <th>MECC020123HDFNRR04 </th>
                                                                                                                            <th>Tarjeta Visa Card</th>
                                                                                                                            <th>1876</th>
                                                                                                                        </tr>

                                                                                                                        <tr>
                                                                                                                            <th>Radiohead</th>
                                                                                                                            <th>Musica</th>
                                                                                                                            <th>Album The King Of Limbs</th>
                                                                                                                            <th>19-02-2016</th>
                                                                                                                            <th>350.00 MXN</th>
                                                                                                                            <th>69.00 MXN</th>
                                                                                                                            <th>diego.goonie@hotmail.com</th>
                                                                                                                            <th>Ajonjoli #3755 Anahuac</th>
                                                                                                                            <th>192378238</th>
                                                                                                                            <th>MECC020123HDFNRR04 </th>
                                                                                                                            <th>Tarjeta Visa Card</th>
                                                                                                                            <th>1876</th>
                                                                                                                        </tr>

                                                                                                                        <tr>
                                                                                                                            <th>Radiohead</th>
                                                                                                                            <th>Musica</th>
                                                                                                                            <th>Album The King Of Limbs</th>
                                                                                                                            <th>19-02-2016</th>
                                                                                                                            <th>350.00 MXN</th>
                                                                                                                            <th>69.00 MXN</th>
                                                                                                                            <th>diego.goonie@hotmail.com</th>
                                                                                                                            <th>Ajonjoli #3755 Anahuac</th>
                                                                                                                            <th>192378238</th>
                                                                                                                            <th>MECC020123HDFNRR04 </th>
                                                                                                                            <th>Tarjeta Visa Card</th>
                                                                                                                            <th>1876</th>
                                                                                                                        </tr>
                                                                                                                        <tr>
                                                                                                                            <th>Radiohead</th>
                                                                                                                            <th>Musica</th>
                                                                                                                            <th>Album The King Of Limbs</th>
                                                                                                                            <th>19-02-2016</th>
                                                                                                                            <th>350.00 MXN</th>
                                                                                                                            <th>69.00 MXN</th>
                                                                                                                            <th>diego.goonie@hotmail.com</th>
                                                                                                                            <th>Ajonjoli #3755 Anahuac</th>
                                                                                                                            <th>192378238</th>
                                                                                                                            <th>MECC020123HDFNRR04 </th>
                                                                                                                            <th>Tarjeta Visa Card</th>
                                                                                                                            <th>1876</th>
                                                                                                                        </tr>
                                                                                                                        <td colspan="10">
                                                                                                                            <th>Total MXN:</th>
                                                                                                                            <th>$1400 MXN</th>
                                                                                                                        </td>
                                                                                                                    </table>
                                                                                                                    </div>
                                                                                                                    </div>
                                                                                                                    </div>
                                                                                                                    </div>
                                                                                                                    </div>
                                                                                                                    <div id="footer">
                                                                                                                        <p><a href="#">Rubén Darío Valdés Banda</a></p>
                                                                                                                        <p><a href="#">Diego Armando Escamilla Morado</a></p>
                                                                                                                        <p><a href="#">Programación para Aplicaciones de la Web</a></p>
                                                                                                                    </div>
                                                                                                                    </body>
                                                                                                                    </html>

