<template>
    <br><br><br><br>
    <div class="main">
                            <div class="inner">
                                <h1>Wypożyczone samochody znajdują się tutaj</h1>

                                <div v-for="car in cars" :key="car.id">
  <!-- content --><li>{{ car.id }}</li>
</div>

                                <table>
                                    <tr>
                                        <td><b>ID</b></td>
                                        <td><b>Marka</b></td>
                                        <td><b>Model</b></td>
                                        <td><b>Start</b></td>
                                        <td><b>Koniec</b></td>
                                        <td><b>Koszt</b></td>
                                            <tr>
                                                <td>12</td>
                                                <td>Ford</td>
                                                <td>Mustang</td>
                                                <td>03.05.24</td>
                                                <td>08.05.24</td>
                                                <td>694zł</td>
                                            </tr>
                                    
                                    </tr>
                                    
                                </table>

                                <p>Z autem należy przyjechać w dniu końca wypożyczenia w godzinach 8:00 - 14:00 na nasz plac znajdujący się w Sosnowcu przy ulicy Sosnowieckiej 12.<br>
                                W przypadku przyjechania tego samego dnia lecz po wyznaczonej godzinie zostanie nałożona opłata adekwatna do wypożyczenia auta na dodatkowy dzień.<br></p>
                                <p>Nie zastosowanie się do powyższych zasad będzie skutkowało zgłoszeniem kradzieży oraz karą pieniężną w wysokości 5000zł/dzień spoźnienia.</p>
                                <p>Przed przyjazdem prosimy o zatankowanie samochodu do pełna.</p>
                            </div>
                        </div>
                        <br><br><br><br>   
                        
                       
							
            
            

            
    </template>