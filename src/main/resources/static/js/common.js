// 테마 설정
const isUserColorTheme = localStorage.getItem('color-theme');	// 유저 선택 테마
const isOsColorTheme = window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light';	// 시스템 테마
const getUserTheme = isUserColorTheme ? isUserColorTheme : isOsColorTheme;

if (getUserTheme === 'dark') {
    document.documentElement.setAttribute('color-theme', 'dark');
} else {
    document.documentElement.setAttribute('color-theme', 'light');
}

// 팝업 호출
alertPop = (function(opt){
    const html = $('<article class="popup"><article>');
    $(html).load('./popup.html',function(responseTxt, statusTxt, xhr){
        if(opt.title) $(this).find('.title').html(opt.title);
        if(opt.content) $(this).find('.content').html(opt.content);

        $(this).find('.confirm').click(function(){
            $(this).closest('.popup').remove();

            return opt.confirm();
        });
    });

    $('body').append(html);
});

//팝업 닫기
$(document).on('click','.popup .cancel',function(){
    $(this).closest('.popup').remove();
});

// 팝업 배경 클릭 시 팝업 닫기
/*$(document).on('click','.alert-bg',function(){
	$(this).parent('.popup').remove();
});*/

//프로필 이미지 클릭
$(document).on('click','.profile-img',function(){
    if ( !document.querySelector('.profile-div').classList.contains('on') )
        document.querySelector('.profile-div').classList.add('on')
    else
        document.querySelector('.profile-div').classList.remove('on')
});

// 메뉴 클릭 이벤트
$(document).on('click','.menu-btn',function(){
    if ( document.querySelector('.menuwrap').classList.contains('on') ) menuOff();
    else menuOn();
});
// 메뉴 배경 클릭
$(document).on('click','.menu-bg',function(){
    menuOff();
});

function menuOn(){
    document.querySelector('.menuwrap').classList.add('on');	//메뉴펼침
    document.querySelector('.menu-btn .one').classList.add('loatate1');
    document.querySelector('.menu-btn .two').classList.add('loatate2');
    document.querySelector('.menu-btn .three').classList.add('fadeout');
    $('.menu-bg').fadeIn();
}
function menuOff(){
    document.querySelector('.menuwrap').classList.remove('on');	//메뉴닫힘
    document.querySelector('.menu-btn .one').classList.remove('loatate1');
    document.querySelector('.menu-btn .two').classList.remove('loatate2');
    document.querySelector('.menu-btn .three').classList.remove('fadeout');
    $('.menu-bg').fadeOut();
}

// 메뉴 타이틀 클릭 이벤트
$('.menu-title').on({
    click : function(){
        $('.menuwrap ul').slideUp();
        $(this).next("ul").slideDown();
    }
});

let $checkbox = document.getElementById('darkMode');			// 다크모드 토글

// 다크테마 토글
$checkbox.addEventListener('click', e=> {
    if(e.target.checked) {
        localStorage.setItem('color-theme', 'dark');
        document.documentElement.setAttribute('color-theme','dark')
    }else{
        localStorage.setItem('color-theme', 'light');
        document.documentElement.setAttribute('color-theme','light')
    }
});

// 테마 불러오기
window.onload = function () {
    if (getUserTheme === 'dark') $checkbox.getElementsByTagName("input")[0].checked = true;
};

$('#pop').click(function(){
    alertPop({
        title : 'test',
        confirm : function(){
            console.log('aa');
        }
    });
});