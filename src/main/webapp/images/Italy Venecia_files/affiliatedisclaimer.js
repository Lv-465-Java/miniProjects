(window.webpackJsonp=window.webpackJsonp||[]).push([["modules/affiliatedisclaimer"],{dacab6c054d6a23aea31:function(e,t,i){"use strict";i.r(t),i.d(t,"default",function(){return a});var l=i("654adc4d2d3e5dbaee18");function n(e,t){for(var i=0;i<t.length;i++){var l=t[i];l.enumerable=l.enumerable||!1,l.configurable=!0,"value"in l&&(l.writable=!0),Object.defineProperty(e,l.key,l)}}var a=function(){function t(){var e=0<arguments.length&&void 0!==arguments[0]?arguments[0]:'a[data-affiliate="true"]';!function(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}(this,t),this.selector=e;this.disclaimer=document.querySelector(".bar-content-disclaimer"),this.disclaimer&&!this.disclaimer.classList.contains("hidden")||(this.placeHolders=document.querySelectorAll(".embed.embed-gallery.media-loader.lazyload"),this.galleryModule=document.querySelectorAll(".gallery-module"),this.disclaimer&&(this.placeHolders.length||this.galleryModule.length)&&(this.galleryModule.length&&!this.placeHolders.length?this.checkDocument():this.listener=Object(l.a)(window,"app.contentLazyLoaded",this.checkDocument.bind(this))))}return function(e,t,i){t&&n(e.prototype,t),i&&n(e,i)}(t,[{key:"checkDocument",value:function(){this.links=document.querySelectorAll(this.selector),this.links.length&&(this.listener&&this.listener.remove(),this.disclaimer.classList.remove("hidden"))}}]),t}()}}]);
//# sourceMappingURL=affiliatedisclaimer.6c61377.js.map