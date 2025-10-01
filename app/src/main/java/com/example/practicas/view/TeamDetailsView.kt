package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicas.components.TitleBar
import com.example.practicas.R
import kotlin.to

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TeamDetailsView(navController: NavController, teamName: String) {

        val (imageId, story, backgroundColor) = when (teamName) {
            "Buffalo Bills" -> Triple(R.drawable.buffalo_bills, "Los Buffalo Bills son uno de los equipos más antiguos de la NFL, fundados en 1960. Alcanzaron notoriedad a finales de los 80 y principios de los 90 gracias a su ofensiva explosiva liderada por Jim Kelly, Thurman Thomas y Andre Reed. Durante esos años, dominaron la AFC y llegaron a cuatro Super Bowls consecutivos (XXV-XXVIII), un récord que ningún otro equipo ha igualado. A pesar de no ganar ninguno de ellos, su consistencia y capacidad competitiva marcaron una era dorada en Buffalo.\n" +
                    "\n" +
                    "El equipo también es recordado por su resiliencia y pasión de sus aficionados, especialmente en el clima extremo de Buffalo. Sus partidos en el estadio Highmark Stadium han sido testigos de históricas remontadas y emocionantes encuentros que consolidaron al equipo como un ícono de la ciudad. Además, el “K-Gun offense” implementado por Marv Levy y Jim Kelly revolucionó la manera de jugar ofensiva rápida en la NFL.\n" +
                    "\n" +
                    "En tiempos recientes, los Bills han recuperado relevancia con una defensiva sólida y la incorporación de Josh Allen como quarterback. Su regreso a los playoffs ha renovado el entusiasmo de los aficionados y ha reforzado la idea de que Buffalo sigue siendo un contendiente serio en la AFC. La identidad del equipo se basa en la perseverancia, la fidelidad de sus hinchas y una rica historia de excelencia competitiva.", Color(0xFFC60C30))

            "Miami Dolphins" -> Triple(R.drawable.miami_dolphins, "Fundados en 1966, los Miami Dolphins rápidamente se hicieron un nombre en la NFL. Bajo la dirección de Don Shula, lograron el único “perfect season” en la historia de la NFL en 1972, ganando todos los partidos de temporada regular y playoffs, incluyendo el Super Bowl VII. Este logro es legendario y sigue siendo un punto de orgullo para la franquicia y sus fanáticos.\n" +
                    "\n" +
                    "Durante los años 70 y 80, los Dolphins contaron con jugadores emblemáticos como Larry Csonka, Bob Griese y Paul Warfield. Su estilo ofensivo y defensivo equilibrado, junto con la disciplina de Shula, los hizo dominar la AFC Este durante varias temporadas consecutivas. El equipo se caracterizó por su consistencia y su capacidad de competir al más alto nivel.\n" +
                    "\n" +
                    "En décadas recientes, los Dolphins han buscado reconstruirse y mantener su reputación de equipo sólido. La incorporación de jóvenes talentos y la modernización de su estrategia han permitido mantenerse competitivos en la AFC Este. Su legado sigue influyendo en el fútbol americano, destacando por excelencia histórica, innovación táctica y compromiso con sus aficionados.", Color(0xFF008E97))

            "New England Patriots" -> Triple(R.drawable.new_england_patriots, "ULos New England Patriots fueron fundados en 1959 y adquirieron fama mundial principalmente durante la era de Bill Belichick y Tom Brady. Este dúo lideró al equipo a seis Super Bowls ganados en menos de 20 años, consolidando a los Patriots como una de las franquicias más exitosas de la historia moderna de la NFL.\n" +
                    "\n" +
                    "Antes de esa era dorada, los Patriots experimentaron altibajos y varias temporadas mediocres, pero lograron establecerse como un equipo sólido dentro de la AFC Este. La disciplina, el trabajo en equipo y la capacidad de reinventarse temporada tras temporada fueron claves en su ascenso. Su estilo de juego se caracterizó por una defensa sólida combinada con ofensivas estratégicas muy bien planificadas.\n" +
                    "\n" +
                    "Hoy en día, los Patriots continúan siendo un referente en términos de organización y cultura ganadora. Aunque Tom Brady ya no está en el equipo, la franquicia sigue enfocada en el desarrollo de talentos jóvenes y en mantener la competitividad en la AFC. Su historia combina períodos de lucha con décadas de éxito sostenido, convirtiéndolos en un ejemplo de resiliencia y planificación estratégica en la NFL.", Color(0xFF002244))

            "New York Jets" -> Triple(R.drawable.new_york_jets, "Fundados en 1959 como Titans de Nueva York, los Jets se renombraron en 1963 y rápidamente dejaron su huella en la historia del fútbol americano. Son mundialmente recordados por ganar el Super Bowl III en 1969, con Joe Namath asegurando la victoria y popularizando la famosa frase “We’re gonna win”. Esta hazaña consolidó a los Jets como un equipo capaz de desafiar cualquier pronóstico.\n" +
                    "\n" +
                    "En las décadas posteriores, los Jets experimentaron altibajos, con temporadas destacadas y otras mediocres. Sin embargo, siempre han mantenido una base de aficionados apasionada que sigue apoyando al equipo sin importar los resultados. Su historia está marcada por decisiones estratégicas, cambios de entrenadores y la constante búsqueda de una identidad sólida dentro de la liga.\n" +
                    "\n" +
                    "Actualmente, los Jets buscan regresar a los playoffs y reconstruir su ofensiva con talentos jóvenes. Su legado se basa en la famosa victoria de Super Bowl III, la pasión de su afición y la capacidad de inspirar momentos históricos que quedan grabados en la memoria de la NFL.", Color(0xFF125740))

            "Houston Texans" -> Triple(R.drawable.houston_texans, "Fundados en 2002, los Texans son la franquicia más joven de la NFL. Su creación buscó expandir la liga en Texas tras la mudanza de los Oilers a Tennessee. Desde entonces, han trabajado en consolidar un equipo competitivo en la AFC Sur.\n" +
                    "Destacados jugadores como Andre Johnson y J.J. Watt han definido la historia reciente del equipo, aportando momentos memorables y estableciendo récords de franquicia. La defensiva, especialmente bajo Watt, se convirtió en su sello distintivo.\n" +
                    "Hoy, los Texans buscan mantenerse competitivos y conectar con una base de aficionados leal, trabajando en desarrollo local y proyección nacional desde el NRG Stadium en Houston.", Color(0xFF03202F))

            "Indianapolis Colts" -> Triple(R.drawable.baltimore_colts, "Originalmente Baltimore Colts, se trasladaron a Indianápolis en 1984. Los Colts han ganado un lugar destacado en la historia de la NFL gracias a jugadores legendarios como Johnny Unitas y Peyton Manning, y múltiples campeonatos de conferencia y un Super Bowl en 2007.\n" +
                    "Su estilo de juego ha destacado por mariscales de campo excepcionales, ofensivas potentes y defensivas sólidas que han llevado al equipo a ser referente en la AFC Sur. La transición a Indianápolis fortaleció la identidad regional y la lealtad de los aficionados.\n" +
                    "Actualmente, los Colts continúan siendo un equipo competitivo, con programas de desarrollo juvenil y un compromiso con la comunidad que refleja la tradición y la modernidad del club.", Color(0xFF002C5F))

            "Jacksonville Jaguars" -> Triple(R.drawable.jacksonville_jaguars, "Fundados en 1993, los Jaguars se unieron a la NFL como parte de la expansión en el sur de Estados Unidos. Desde sus primeros años, mostraron un estilo de juego agresivo y estratégico que los colocó como competidores destacados en la AFC Sur.\n" +
                    "Destacaron jugadores como Fred Taylor, Jimmy Smith y Tony Boselli, que contribuyeron al crecimiento del equipo y a sus incursiones en playoffs. La franquicia ha buscado construir una cultura ganadora y establecerse como referente regional.\n" +
                    "Hoy, los Jaguars continúan su desarrollo competitivo, con foco en jóvenes talentos y una base de aficionados apasionados en Jacksonville, buscando alcanzar nuevamente la élite de la conferencia.", Color(0xFF006778))

            "Tennessee Titans" -> Triple(R.drawable.tennessee_titans, "Los Titans surgieron tras la mudanza de los Houston Oilers a Tennessee en 1997. Con una historia ligada a la transformación de la franquicia, han destacado por su ofensiva potente y su juego físico, siendo un equipo difícil de vencer en la AFC Sur.\n" +
                    "Destacados jugadores como Steve McNair, Eddie George y Derrick Henry han marcado hitos en la historia del equipo. El memorable Super Bowl XXXIV, aunque perdido por poco, sigue siendo un momento clave de la franquicia.\n" +
                    "Actualmente, los Titans combinan juventud y experiencia, buscando consolidar un proyecto sólido en la liga, con el apoyo incondicional de sus aficionados en el Nissan Stadium de Nashville.", Color(0xFF4B92DB))

            "Baltimore Ravens" -> Triple(R.drawable.baltimore_ravens, "Los Baltimore Ravens fueron fundados en 1996 tras la mudanza de los Cleveland Browns a Baltimore. Desde sus inicios, se distinguieron por su fuerte identidad defensiva, convirtiéndose en sinónimo de fuerza, disciplina y táctica. La defensiva 2000, con Ray Lewis y compañía, es considerada una de las mejores en la historia de la NFL.\n" +
                    "En 2000, ganaron su primer Super Bowl tras derrotar a los New York Giants, estableciendo un estándar de excelencia en la franquicia. Posteriormente, lograron otro título en 2012 con Joe Flacco como mariscal de campo, consolidando su reputación de equipo competitivo y bien estructurado.\n" +
                    "Además de los logros deportivos, los Ravens han desarrollado un fuerte vínculo con la comunidad de Baltimore, promoviendo programas sociales y educativos. Su estadio, M&T Bank Stadium, es un punto de encuentro para la pasión futbolera de la ciudad y la cultura deportiva de la región.", Color(0xFF241773))

            "Cincinnati Bengals" -> Triple(R.drawable.cincinnati_bengals, "Fundados en 1968, los Bengals surgieron como parte de la AFL y rápidamente se consolidaron en la AFC Norte tras la fusión con la NFL. Bajo el liderazgo de Paul Brown, la franquicia estableció una identidad sólida basada en disciplina, estrategia y desarrollo de talento local.\n" +
                    "A lo largo de los años, jugadores como Ken Anderson, Boomer Esiason y más recientemente Joe Burrow, han sido figuras icónicas que llevaron al equipo a playoffs y apariciones en Super Bowl, destacando la resiliencia y capacidad competitiva de la franquicia.\n" +
                    "Hoy, los Bengals representan un símbolo de orgullo regional en Cincinnati, combinando tradición y modernidad, y consolidando un proyecto deportivo que busca mantener el éxito sostenido en la AFC Norte.", Color(0xFFFF4B00))

            "Cleveland Browns" -> Triple(R.drawable.cleveland_browns, "Los Cleveland Browns fueron fundados en 1946 y son uno de los equipos más históricos de la NFL. Conocidos por su legendario entrenador Paul Brown, establecieron un legado de innovación táctica y ofensivas avanzadas que influyeron en el desarrollo del fútbol americano profesional.\n" +
                    "A pesar de períodos difíciles tras su reubicación temporal, los Browns han tenido momentos destacados, incluyendo múltiples campeonatos de liga en las décadas de los 50 y 60. Jugadores como Jim Brown y Otto Graham son íconos que definieron la excelencia y el estilo de juego de la franquicia.\n" +
                    "Actualmente, los Browns buscan consolidar un equipo competitivo con jóvenes talentos y mantener el apoyo ferviente de sus aficionados, siendo un símbolo cultural y deportivo de Cleveland.", Color(0xFF311D00))

            "Pittsburgh Steelers" -> Triple(R.drawable.pittsburgh_steelers, "Los Pittsburgh Steelers fueron fundados en 1933 y son una de las franquicias más exitosas de la NFL, con seis Super Bowls ganados, la mayor cantidad en la historia de la liga. Conocidos por su “Steel Curtain” defensivo en los 70, marcaron un estándar de fortaleza, disciplina y táctica implacable.\n" +
                    "Jugadores legendarios como Terry Bradshaw, Franco Harris y Mean Joe Greene contribuyeron a forjar la historia de dominación del equipo. A lo largo de décadas, los Steelers han mantenido una filosofía de consistencia y competitividad, siendo siempre protagonistas en playoffs.\n" +
                    "Más allá de los logros deportivos, los Steelers representan el espíritu de la ciudad de Pittsburgh: resiliencia, trabajo duro y pasión por el fútbol americano. Su base de aficionados es una de las más fieles y ruidosas, conocida como “Steeler Nation”.", Color(0xFFFFB612))

            "Denver Broncos" -> Triple(R.drawable.denver_broncos, "Fundados en 1960 como parte de la AFL, los Denver Broncos se unieron a la NFL tras la fusión de 1970. Desde sus comienzos, el equipo se destacó por su ofensiva explosiva y su capacidad de adaptarse a diferentes estilos de juego.\n" +
                    "John Elway lideró la franquicia a dos Super Bowls consecutivos en los 90 y luego al campeonato de 1998, convirtiéndose en una de las leyendas más reconocidas de la NFL. Además, jugadores como Terrell Davis marcaron una época dorada en la ofensiva de Denver.\n" +
                    "Hoy, los Broncos continúan siendo un equipo competitivo en la AFC West, con una base de aficionados apasionada que llena el Empower Field y mantiene viva la tradición y el orgullo de la franquicia.", Color(0xFFFF6600))

            "Kansas City Chiefs" -> Triple(R.drawable.kansas_city_chiefs, "Los Kansas City Chiefs fueron fundados en 1960 como los Dallas Texans y se trasladaron a Kansas City en 1963. Son conocidos por su rica historia y por la innovación en ofensivas explosivas. Bajo el liderazgo de Lamar Hunt, fundador de la AFL, se convirtieron en uno de los equipos más emblemáticos de la liga.\n" +
                    "Patrick Mahomes y Travis Kelce han llevado a los Chiefs a un nuevo nivel, ganando el Super Bowl LIV y estableciendo récords ofensivos impresionantes. Su estilo agresivo y dinámico ha redefinido el fútbol moderno.\n" +
                    "Además de los logros deportivos, los Chiefs representan la cultura y el espíritu de Kansas City, fomentando la pasión por el fútbol americano y la conexión con la comunidad local a través de diversas iniciativas sociales.", Color(0xFFE31837))

            "Las Vegas Raiders" -> Triple(R.drawable.las_vegas_raiders, "Originalmente Oakland Raiders, la franquicia fue fundada en 1960 y se trasladó a Los Ángeles, luego de regreso a Oakland y finalmente a Las Vegas en 2020. Los Raiders son reconocidos por su identidad agresiva y su cultura rebelde dentro de la NFL.\n" +
                    "Con jugadores icónicos como Marcus Allen, Ken Stabler y Howie Long, lograron múltiples campeonatos de Super Bowl y crearon una reputación de equipo temido por su defensa y estilo físico.\n" +
                    "Hoy, los Raiders continúan su legado en Las Vegas, manteniendo una base de aficionados leales y apasionados. El Allegiant Stadium simboliza la modernidad y la tradición del equipo, fusionando historia y espectáculo deportivo.", Color(0xFF000000))

            "Los Angeles Chargers" -> Triple(R.drawable.los_angeles_chargers, "Fundados en 1960 como parte de la AFL, los Chargers se trasladaron varias veces, desde Los Ángeles a San Diego y de regreso a Los Ángeles en 2017. Han sido un equipo caracterizado por ofensivas rápidas y mariscales de campo talentosos.\n" +
                    "Dan Fouts y LaDainian Tomlinson destacan como íconos históricos del equipo, liderando temporadas memorables y estableciendo récords de franquicia. A pesar de no lograr un campeonato de Super Bowl, los Chargers siempre han sido competitivos y respetados en la AFC West.\n" +
                    "Actualmente, buscan consolidar un proyecto sólido en Los Ángeles, manteniendo su base de aficionados y proyectando la identidad del equipo hacia futuras generaciones, mientras desarrollan jóvenes talentos prometedores.", Color(0xFF002A5C))

            "Dallas Cowboys" -> Triple(R.drawable.dallas_cowboys, "Los Dallas Cowboys fueron fundados en 1960 y rápidamente se convirtieron en uno de los equipos más emblemáticos de la NFL. Conocidos como “America’s Team”, han logrado cinco títulos de Super Bowl y numerosas apariciones en playoffs, consolidando una tradición de éxito y competitividad.\n" +
                    "Jugadores icónicos como Roger Staubach, Emmitt Smith y Troy Aikman marcaron la historia de la franquicia, definiendo su estilo ofensivo y su capacidad de ganar partidos clave. La combinación de talento individual y estrategia colectiva ha sido clave para sus triunfos históricos.\n" +
                    "Además de su éxito en el campo, los Cowboys son un símbolo cultural en Estados Unidos, con una base de aficionados enorme y apasionada. Su estadio, el AT&T Stadium en Arlington, es uno de los más impresionantes del mundo y refleja el poder y la grandeza de la franquicia.", Color(0xFF041E42))

            "New York Giants" -> Triple(R.drawable.new_york_giants, "Fundados en 1925, los New York Giants son uno de los equipos más antiguos y respetados de la NFL. Han ganado ocho campeonatos de liga, incluyendo cuatro Super Bowls, y han sido protagonistas de momentos históricos en la historia del fútbol americano.\n" +
                    "Leyendas como Lawrence Taylor, Phil Simms y Eli Manning han liderado al equipo en sus mejores épocas, destacándose por su capacidad de resiliencia y adaptabilidad en temporadas decisivas. Los Giants siempre han combinado tradición con innovación en su estilo de juego.\n" +
                    "Además de sus logros deportivos, los Giants representan la cultura y la pasión de Nueva York, manteniendo una base de aficionados leales y comprometidos. Su estadio, el MetLife Stadium, compartido con los Jets, es un emblema de la magnitud y la importancia del equipo en la liga.", Color(0xFF0B2265))

            "Philadelphia Eagles" -> Triple(R.drawable.philadelphia_eagles, "Los Philadelphia Eagles fueron fundados en 1933 y han tenido una historia marcada por la resiliencia y la pasión de sus seguidores. Conocidos por su defensa férrea y un estilo de juego físico, han conseguido tres campeonatos de liga y un histórico Super Bowl en 2018.\n" +
                    "Jugadores como Reggie White, Chuck Bednarik y Donovan McNabb han dejado una huella imborrable en la historia del equipo, combinando talento, liderazgo y determinación. La franquicia ha sabido reinventarse en distintas épocas para mantenerse competitiva en la NFC East.\n" +
                    "Los Eagles representan el espíritu de Filadelfia: trabajo duro, entrega y lealtad inquebrantable. Su estadio, Lincoln Financial Field, es un centro de encuentro para la comunidad y un símbolo de orgullo para la ciudad, donde los fans viven intensamente cada temporada.", Color(0xFF004C54))

            "Washington Commanders" -> Triple(R.drawable.washington_commanders, "Los Washington Commanders, fundados en 1932 como Boston Braves y luego mudados a Washington, han tenido una historia rica y compleja, con múltiples campeonatos de liga y tres títulos de Super Bowl. La franquicia se distingue por su tradición defensiva y su capacidad para reinventarse a lo largo de las décadas.\n" +
                    "Jugadores legendarios como Sammy Baugh, Darrell Green y John Riggins han dejado una marca imborrable en la historia del equipo, contribuyendo a momentos históricos y temporadas memorables. Washington ha sabido combinar talento y estrategia para mantenerse competitivo en la NFC East.\n" +
                    "El equipo también representa un símbolo de identidad y orgullo para la ciudad de Washington D.C., con aficionados apasionados que siguen cada temporada. Su estadio, FedExField, es un punto de encuentro para la comunidad y refleja la importancia cultural y deportiva de la franquicia.", Color(0xFF5A1414))

            "Chicago Bears" -> Triple(R.drawable.chicago_bears, "Los Chicago Bears, fundados en 1919, son uno de los equipos más históricos y emblemáticos de la NFL. Conocidos por su tradicional defensa dura y su estilo de juego físico, han ganado nueve campeonatos de liga, incluyendo un Super Bowl en 1985. Su legado defensivo ha influido en toda la liga, y la franquicia es un símbolo del fútbol americano clásico.\n" +
                    "Jugadores legendarios como Walter Payton, Dick Butkus y Mike Singletary marcaron la historia del equipo, combinando talento, disciplina y un carácter inquebrantable. Cada generación de Bears ha sabido mantener la esencia del equipo: fortaleza, resiliencia y espíritu competitivo.\n" +
                    "El Soldier Field, hogar de los Bears, refleja la importancia cultural de la franquicia en Chicago, siendo un lugar de encuentro para aficionados y un símbolo de orgullo para la ciudad. La base de fans es conocida por su lealtad, acompañando al equipo en los momentos más difíciles y celebrando cada triunfo con pasión.", Color(0xFF0B162A))

            "Detroit Lions" -> Triple(R.drawable.detroit_lions, "Fundados en 1930, los Detroit Lions tienen una historia marcada por la perseverancia y la dedicación, a pesar de enfrentar largos periodos sin campeonatos. Conocidos por su ofensiva rápida y jugadores de gran talento, la franquicia ha dejado momentos memorables en la historia de la NFL.\n" +
                    "Leyendas como Barry Sanders, Calvin Johnson y Joe Schmidt han definido distintas épocas del equipo, dejando un legado de excelencia individual y trabajo en equipo. Los Lions han sabido combinar estrategias ofensivas innovadoras con una defensa sólida, buscando siempre competir al más alto nivel.\n" +
                    "El Ford Field, hogar de los Lions, es un centro de pasión y energía para la ciudad de Detroit. La afición, aunque ha vivido años difíciles, mantiene una devoción inquebrantable, convirtiendo cada partido en una experiencia única y emocionante, reflejando el espíritu de resiliencia de la franquicia.", Color(0xFF0076B6))

            "Green Bay Packers" -> Triple(R.drawable.green_bay_packers, "Los Green Bay Packers, fundados en 1919, son uno de los equipos más legendarios y exitosos de la NFL. Han ganado 13 campeonatos de liga, incluyendo cuatro Super Bowls, consolidándose como un referente histórico del fútbol americano profesional. La franquicia es famosa por su estilo de juego inteligente y su estructura única de propiedad comunitaria.\n" +
                    "Jugadores icónicos como Bart Starr, Brett Favre y Aaron Rodgers han llevado al equipo a la gloria, mostrando liderazgo, precisión y capacidad de innovación en cada temporada. La historia de los Packers está llena de momentos épicos que han definido el desarrollo de la liga y el deporte en general.\n" +
                    "El Lambeau Field, conocido como “The Frozen Tundra”, es un santuario para los aficionados, quienes forman parte de la propiedad del equipo y participan activamente en la cultura de la franquicia. La pasión de los seguidores de Green Bay es legendaria, haciendo de cada partido una experiencia histórica.", Color(0xFF203731))

            "Minnesota Vikings" -> Triple(R.drawable.minnesota_vikings, "Fundados en 1961, los Minnesota Vikings se han destacado por su consistencia y competitividad en la NFC North. Conocidos por su defensa fuerte y su juego estratégico, han disputado múltiples Super Bowls y playoffs, dejando una huella importante en la historia de la NFL.\n" +
                    "Jugadores legendarios como Fran Tarkenton, Randy Moss y Alan Page han definido la historia del equipo, destacándose por su talento, liderazgo y determinación. Los Vikings han sabido adaptarse a las distintas épocas del fútbol americano, manteniendo su esencia de lucha y resiliencia en el campo.\n" +
                    "El U.S. Bank Stadium, hogar de los Vikings, refleja la importancia de la franquicia para la ciudad de Minneapolis y toda Minnesota. Los aficionados son apasionados y fieles, convirtiendo cada partido en una celebración de la cultura deportiva local y del orgullo por su equipo.", Color(0xFF4F2683))

            "Atlanta Falcons" -> Triple(R.drawable.atlanta_falcons, "Los Atlanta Falcons fueron fundados en 1965 y se han destacado por su juego ofensivo ágil y por momentos históricos de gran intensidad en la NFL. A lo largo de su historia, han disputado Super Bowls y playoffs, dejando un legado de resiliencia y perseverancia a pesar de las dificultades enfrentadas en temporadas desafiantes.\n" +
                    "Jugadores legendarios como Deion Sanders, Michael Vick y Julio Jones han marcado la historia del equipo, demostrando velocidad, talento y liderazgo en el campo. Cada generación de Falcons ha buscado consolidar una identidad basada en la creatividad ofensiva y la capacidad de adaptación frente a rivales exigentes.\n" +
                    "El Mercedes-Benz Stadium, hogar de los Falcons, representa un centro de pasión deportiva para Atlanta, donde los aficionados viven cada partido con intensidad y orgullo. La base de fans del equipo es conocida por su lealtad y entusiasmo, acompañando a la franquicia en cada etapa de su desarrollo.", Color(0xFF000000))

            "Carolina Panthers" -> Triple(R.drawable.carolina_panthers, "Los Carolina Panthers se unieron a la NFL en 1995 y rápidamente se convirtieron en un equipo competitivo en la NFC South. Su identidad se ha caracterizado por un juego físico y dinámico, buscando siempre sorprender a sus rivales con estrategias ofensivas y defensivas equilibradas.\n" +
                    "Jugadores icónicos como Cam Newton, Julius Peppers y Luke Kuechly han dejado un legado de excelencia, demostrando que la combinación de talento y disciplina puede llevar a un equipo joven a la élite de la liga. Los Panthers han disputado finales de conferencia y playoffs, consolidándose como un equipo respetado por su intensidad y preparación.\n" +
                    "El Bank of America Stadium es el hogar de la franquicia, y se ha convertido en un punto de encuentro para la comunidad de Charlotte. Los aficionados muestran una pasión inquebrantable, reflejando el orgullo por su equipo y celebrando cada éxito como un logro colectivo.", Color(0xFF0085CA))

            "New Orleans Saints" -> Triple(R.drawable.new_orleans_saints, "Fundados en 1967, los New Orleans Saints han construido una historia de superación y orgullo, convirtiéndose en uno de los equipos más emblemáticos de la NFC South. Su estilo de juego combina ofensiva potente con una defensa estratégica, y han logrado dejar una marca histórica tras ganar el Super Bowl XLIV en 2010.\n" +
                    "Jugadores legendarios como Drew Brees, Reggie Bush y Archie Manning han definido la historia de los Saints, destacándose por su liderazgo, talento y capacidad de inspirar tanto dentro como fuera del campo. La franquicia ha sabido superar momentos difíciles, incluyendo desastres naturales, fortaleciendo el vínculo con la ciudad y la afición.\n" +
                    "El Caesars Superdome es un símbolo cultural y deportivo de Nueva Orleans, donde los aficionados celebran con entusiasmo y pasión cada partido. La conexión entre equipo y comunidad es única, reflejando un espíritu de resiliencia, identidad y orgullo local.", Color(0xFFD3BC8D))

            "Tampa Bay Buccaneers" -> Triple(R.drawable.tampa_bay_buccaneers, "Fundados en 1967, los New Orleans Saints han construido una historia de superación y orgullo, convirtiéndose en uno de los equipos más emblemáticos de la NFC South. Su estilo de juego combina ofensiva potente con una defensa estratégica, y han logrado dejar una marca histórica tras ganar el Super Bowl XLIV en 2010.\n" +
                    "Jugadores legendarios como Drew Brees, Reggie Bush y Archie Manning han definido la historia de los Saints, destacándose por su liderazgo, talento y capacidad de inspirar tanto dentro como fuera del campo. La franquicia ha sabido superar momentos difíciles, incluyendo desastres naturales, fortaleciendo el vínculo con la ciudad y la afición.\n" +
                    "El Caesars Superdome es un símbolo cultural y deportivo de Nueva Orleans, donde los aficionados celebran con entusiasmo y pasión cada partido. La conexión entre equipo y comunidad es única, reflejando un espíritu de resiliencia, identidad y orgullo local.", Color(0xFFD50A0A))

            "Arizona Cardinals" -> Triple(R.drawable.arizona_cardinals, "Los Arizona Cardinals son uno de los equipos más antiguos de la NFL, fundados en 1898, con una historia que combina tradición y evolución constante. A lo largo de los años, han pasado de ser un equipo con dificultades iniciales a consolidarse como un competidor sólido en la NFC West, destacando por su ofensiva dinámica y su capacidad de adaptación estratégica.\n" +
                    "Jugadores legendarios como Larry Fitzgerald, Pat Tillman y Kurt Warner han marcado la historia de la franquicia, mostrando talento, liderazgo y un compromiso inquebrantable dentro y fuera del campo. La combinación de experiencia histórica y juventud emergente ha permitido a los Cardinals mantenerse competitivos y buscar protagonismo en la liga.\n" +
                    "El State Farm Stadium, ubicado en Glendale, Arizona, es un epicentro de pasión deportiva donde los aficionados apoyan al equipo con entusiasmo, celebrando cada triunfo y acompañando en los momentos difíciles. La comunidad local ha desarrollado una relación profunda con el equipo, reflejando identidad, orgullo y lealtad hacia la franquicia.", Color(0xFFA71930))

            "Los Angeles Rams" -> Triple(R.drawable.angeles_rams, "Los Los Angeles Rams tienen una trayectoria destacada en la NFL desde su fundación en 1936, caracterizándose por su juego ofensivo innovador y defensas sólidas. Tras múltiples mudanzas y períodos de reestructuración, se han establecido como un equipo con historia, logrando conquistar Super Bowls y dejando huella en la liga por su competitividad y estilo de juego agresivo.\n" +
                    "Jugadores icónicos como Eric Dickerson, Marshall Faulk y Aaron Donald han definido la identidad de los Rams, combinando talento, velocidad y liderazgo, que han llevado al equipo a ser un contendiente constante en playoffs y finales de conferencia. Cada temporada refleja la capacidad de la franquicia para adaptarse y superar desafíos.\n" +
                    "El SoFi Stadium en Inglewood es el hogar moderno de los Rams, un estadio de vanguardia donde los aficionados disfrutan de una experiencia única, apoyando al equipo con pasión y orgullo. La cultura del equipo refleja innovación, identidad y compromiso, consolidando a Los Angeles como una ciudad clave en la historia de la NFL.", Color(0xFF003594))

            "San Francisco 49ers" -> Triple(R.drawable.san_francisco, "Los San Francisco 49ers, fundados en 1946, son un equipo emblemático de la NFL, conocido por su excelencia histórica y su dominio en varias eras, especialmente en los años 80 y 90. Su juego se ha caracterizado por ofensivas potentes y estrategias defensivas inteligentes, consolidando su reputación como uno de los equipos más respetados de la liga.\n" +
                    "Jugadores legendarios como Joe Montana, Jerry Rice y Steve Young han definido la historia de los 49ers, aportando talento extraordinario y liderazgo ejemplar, que ha llevado al equipo a ganar múltiples Super Bowls y establecer un legado duradero en el fútbol americano profesional. La combinación de tradición y modernidad sigue marcando su identidad competitiva.\n" +
                    "El Levi’s Stadium en Santa Clara es un lugar de encuentro para los aficionados, quienes muestran una pasión intensa y un compromiso profundo con la franquicia. Cada partido se vive como un evento histórico, reflejando la importancia cultural y deportiva de los 49ers en la región y en la NFL.", Color(0xFFAA0000))

            "Seattle Seahawks" -> Triple(R.drawable.seattle_seahawks, "Los Seattle Seahawks, fundados en 1976, son reconocidos por su estilo de juego físico y agresivo, así como por su fuerte defensa conocida como \"Legion of Boom\". A lo largo de su historia, han sabido consolidarse como un equipo competitivo en la NFC West, alcanzando Super Bowls y demostrando resiliencia en cada temporada.\n" +
                    "Jugadores destacados como Russell Wilson, Steve Largent y Richard Sherman han dejado una marca imborrable en la historia del equipo, mostrando habilidad, liderazgo y determinación que inspiran tanto a sus compañeros como a los aficionados. La franquicia ha logrado combinar talento individual con un sólido trabajo en equipo, logrando victorias memorables.\n" +
                    "El Lumen Field es el hogar de los Seahawks y uno de los estadios más emblemáticos de la NFL, donde los aficionados, conocidos como “12th Man”, crean un ambiente impresionante y lleno de energía. La relación entre la ciudad de Seattle y el equipo refleja orgullo, pasión y lealtad inquebrantable hacia la franquicia.", Color(0xFF002244))

            else -> Triple(R.drawable.ic_launcher_background, "Historia no disponible", Color.LightGray)
        }

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = teamName,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Atrás",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = backgroundColor
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = teamName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(16.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(color = backgroundColor)
                        .padding(16.dp)
                ) {
                    Text(
                        text = story,
                        color = Color.White
                    )
                }
            }
        }
    }
