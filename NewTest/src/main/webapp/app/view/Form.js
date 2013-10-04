Ext.define('HT.view.Form', {
    extend: 'Ext.tab.Panel',
    alias: 'widget.form',
    title: '首页设置',
    html: '首页设置',
    id: 'homeSet',
    listeners: {
        remove: function (tp, c) {
            c.hide();
        }
    },
    autoDestroy: false,
    contentEl: 'homeSetDiv'
});