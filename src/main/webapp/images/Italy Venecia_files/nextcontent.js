(window.webpackJsonp=window.webpackJsonp||[]).push([["modules/nextcontent"],{aadc7fac9270e944b350:function(e,t,n){"use strict";n.r(t);var r=n("a4a92fe9c6eecbf958fe"),o=n("114e6051b0f5f7c39077"),c=n("654adc4d2d3e5dbaee18");function a(e,t){return function(e){if(Array.isArray(e))return e}(e)||function(e,t){if(!(Symbol.iterator in Object(e)||"[object Arguments]"===Object.prototype.toString.call(e)))return;var n=[],r=!0,o=!1,c=void 0;try{for(var a,l=e[Symbol.iterator]();!(r=(a=l.next()).done)&&(n.push(a.value),!t||n.length!==t);r=!0);}catch(e){o=!0,c=e}finally{try{r||null==l.return||l.return()}finally{if(o)throw c}}return n}(e,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var l,i,u=document.querySelector(".content-container");function d(e,t,n){var r;switch(i){case"gallery":!function(e,t){new l({contentId:t,el:e.querySelector(".slideshow-inner"),isNextGallery:!0})}(t,n),r=t.querySelector(".slide-container");break;case"long-form-article":!function(e){var t=new l({el:e.querySelector(".content-lede-loop")});t.displayLoopOrFallback()}(e),r=t.querySelector(".longform-body");break;case"standard-article":!function(e){var t=new l({el:e.querySelector(".content-lede-loop")});t.displayLoopOrFallback()}(t),r=t.querySelector(".standard-body-content");break;default:return}o.a.trigger("adApiUpdate",{container:r,lazyload:!1}),o.a.trigger("nextContentLoaded")}var f=Object(r.a)([function(e,t){t.disconnect();var n=a(function(){var e=u.querySelector(".next-with-recirc > a");return e?[e.attributes["data-id"].value,"".concat(e.attributes.href.value,"?content-only=yes")]:[]}(),2),o=n[0],r=n[1];o&&Promise.resolve().then(function(){return function(e){return fetch(e)}(r)}).then(function(e){return e.text()}).then(function(e){return Object(c.s)(function(){return function(e){var t=document.createElement("div");return t.innerHTML=e,[t.querySelector(".content-header, .longform-header"),t.querySelector(".content-container")]}(e)})}).then(function(e){var t=a(e,2),n=t[0],r=t[1];return Object(c.s)(function(){return function(e,t){u.parentNode.insertBefore(t,u.nextSibling),u.parentNode.insertBefore(e,u.nextSibling)}(n,r),[n,r]})}).then(function(e){var t=a(e,2),n=t[0],r=t[1];return Object(c.s)(function(){return d(n,r,o)})})},c.o]);t.default=function(e,t){l=t,i=e;var n=function(){switch(i){case"gallery":var e=u.querySelectorAll(".slideshow-slide.loaded");return e.item(e.length-6)||e.item(0);case"standard-article":return u.querySelector(".standard-body-content > :nth-last-child(10)")||u.querySelector(".standard-body-content > :first-child");case"long-form-article":return u.querySelector(".longform-body > :nth-last-child(10)")||u.querySelector(".longform-body > :first-child");default:return null}}();n&&f.observe(n)}}}]);
//# sourceMappingURL=nextcontent.fc85d24.js.map