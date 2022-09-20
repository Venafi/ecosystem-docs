<!-- This component creates three mini cards that act like tabs when clicked. On initial page load,
all the content is hidden. Once a tab is clicked, the content is shown. The js that makes this
work in is in _scripts/scripts.js. -->


<!-- This div creates the tabs. In each div, enter the text you want to appear in the mini card. -->
<div class="card_container tab">
    <!-- mini card -->
    <a class="mini_card tablinks" style="align-items: normal" onclick="openDiv(event, 'DivId1')">
        <!-- <img alt="Placeholder" src="../../assets/icons/connections.svg" align="left"> -->
        <div class="text">
            <h4>I don't have a {{vsat}} or {{vsatw}}</h4>
            <p>Start here if you're brand new or unsure where to begin</p>
        </div>
    </a>
    <!-- /mini card -->
    <!-- mini card -->
    <a class="mini_card tablinks" style="align-items: normal" onclick="openDiv(event, 'DivId2')">
        <!-- <img alt="Placeholder" src="../../assets/icons/config.svg" align="left"> -->
        <div class="text">
            <h4>I have a {{vsat}} but no {{vsatw}}</h4>
            <p>If you've already got a {{vsat}} but need to add a {{vsatw}}</p>
        </div>
    </a>
    <!-- /mini card -->
    <!-- mini card -->
    <a class="mini_card tablinks" style="align-items: normal" onclick="openDiv(event, 'DivId3')">
        <!-- <img alt="Placeholder" src="../../assets/icons/vsat.svg" align="left"> -->
        <div class="text">
            <h4>I already have a {{vsat}} and a {{vsatw}}</h4>
            <p>You're in great shape. Click here to finish the configuration.</p>
        </div>
    </a>
    <!-- /mini card -->
</div>

<!-- This is the content that will be seen when the mini cards are clicked. The three divs here
align with the three divs in the section above. -->
<div id="DivId1" class="tabcontent">
    <h3>Content </h3>
</div>

<div id="DivId2" class="tabcontent">
    <h3>Content </h3>
</div>

<div id="DivId3" class="tabcontent">
    <h3>Content </h3>
</div>