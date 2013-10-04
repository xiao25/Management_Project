Ext.define('HT.model.Students',
    {
        //��Ҫ���˼̳�
        extend: 'Ext.data.Model',

        fields: [
            {name: 'stunum', mapping: 'stunum', type: 'string'},
            {name: 'stuname', mapping: 'stuname', type: 'string'},
            {name: 'sex', mapping: 'sex', type: 'string'},
            {name: 'classnum', mapping: 'classnum', type: 'string'},
            {name: 'phone', mapping: 'phone', type: 'string'},
            {name: 'birthday', mapping: 'birthday', type: 'date', dataFormat: 'Y-m-d'},
            {name: 'address', mapping: 'address', type: 'string'},
            {name: 'remark', mapping: 'remark', type: 'string'}
        ]
    }
)