// Cassiopeia_313751158View.cpp : implementation of the CCassiopeia_313751158View class
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"
#include<stdlib.h>

#include <time.h>

#include "Cassiopeia_313751158Doc.h"
#include "Cassiopeia_313751158View.h"

#include "PassWord.h"
#include "Login.h"
#include "MenuAll.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158View

IMPLEMENT_DYNCREATE(CCassiopeia_313751158View, CFormView)

BEGIN_MESSAGE_MAP(CCassiopeia_313751158View, CFormView)
	//{{AFX_MSG_MAP(CCassiopeia_313751158View)
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	ON_BN_CLICKED(IDC_BUTTON2, OnButton2)
	ON_BN_CLICKED(IDC_BUTTON3, OnButton3)
	ON_BN_CLICKED(IDC_BUTTON4, OnButton4)
	ON_BN_CLICKED(IDC_RADIO1, OnRadio1)
	ON_BN_CLICKED(IDC_RADIO2, OnRadio2)
	ON_BN_CLICKED(IDC_RADIO3, OnRadio3)
	ON_BN_CLICKED(IDC_RADIO4, OnRadio4)
	ON_BN_CLICKED(IDC_RADIO5, OnRadio5)
	ON_BN_CLICKED(IDC_BUTTON5, OnButton5)
	ON_BN_CLICKED(IDC_BUTTON6, OnButton6)
	ON_NOTIFY(NM_CLICK, IDC_LIST2, OnClickList2)
	ON_WM_KILLFOCUS()
	ON_COMMAND(ID_FILE_SAVE, OnFileSave)
	ON_WM_CTLCOLOR()
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CFormView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CFormView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CFormView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158View construction/destruction

CCassiopeia_313751158View::CCassiopeia_313751158View()
	: CFormView(CCassiopeia_313751158View::IDD)
{
	//{{AFX_DATA_INIT(CCassiopeia_313751158View)
	m_strStatic1 = _T("");
	m_strEdit2 = _T("");
	m_floEdit1 = _T("");
	//}}AFX_DATA_INIT
	// TODO: add construction code here

}

CCassiopeia_313751158View::~CCassiopeia_313751158View()
{
}

void CCassiopeia_313751158View::DoDataExchange(CDataExchange* pDX)
{
	CFormView::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CCassiopeia_313751158View)
	DDX_Control(pDX, IDC_DATETIMEPICKER1, m_timeTime);
	DDX_Control(pDX, IDC_COMBO1, m_ctrCombo1);
	DDX_Control(pDX, IDC_LIST2, m_ctrList1);
	DDX_Text(pDX, IDC_STATIC1, m_strStatic1);
	DDX_Text(pDX, IDC_EDIT2, m_strEdit2);
	DDX_Text(pDX, IDC_EDIT1, m_floEdit1);
	//}}AFX_DATA_MAP
}

BOOL CCassiopeia_313751158View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CFormView::PreCreateWindow(cs);
}

void CCassiopeia_313751158View::OnInitialUpdate()
{
	CFormView::OnInitialUpdate();
	GetParentFrame()->RecalcLayout();
	ResizeParentToFit();
	//���FormView�ĳ�ʼ��

	CWnd* pWnd;
	pWnd=GetDlgItem(IDC_BUTTON3);
	pWnd->EnableWindow(false);

	pWnd=GetDlgItem(IDC_BUTTON4);
	pWnd->EnableWindow(false);

	pWnd=GetDlgItem(IDC_BUTTON5);
	pWnd->EnableWindow(false);

	pWnd=GetDlgItem(IDC_BUTTON6);
	pWnd->EnableWindow(false);

	radio2=40;

	radio1=5;
	
	m_ctrCombo1.AddString("����˵��");
		
	m_ctrCombo1.SetCurSel(0);

	m_ctrList1.SetExtendedStyle(LVS_EX_FULLROWSELECT | LVS_EX_GRIDLINES);	//������չ��ʽ

	m_ctrList1.EnableWindow(false);

	m_strStatic1 = "δ����";

	UpdateData(false);

}

/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158View printing

BOOL CCassiopeia_313751158View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CCassiopeia_313751158View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CCassiopeia_313751158View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

void CCassiopeia_313751158View::OnPrint(CDC* pDC, CPrintInfo* /*pInfo*/)
{
	// TODO: add customized printing code here
}

/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158View diagnostics

#ifdef _DEBUG
void CCassiopeia_313751158View::AssertValid() const
{
	CFormView::AssertValid();
}

void CCassiopeia_313751158View::Dump(CDumpContext& dc) const
{
	CFormView::Dump(dc);
}

CCassiopeia_313751158Doc* CCassiopeia_313751158View::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CCassiopeia_313751158Doc)));
	return (CCassiopeia_313751158Doc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158View message handlers

void CCassiopeia_313751158View::OnButton1() 
{
	//����
//	CPassWord dlg;
//	dlg.DoModal();

	CMenuAll dlg;
	dlg.DoModal();
}

void CCassiopeia_313751158View::OnButton2() 
{
	// TODO: Add your control notification handler code here
	// �����ݿ�



	CWnd* pWnd;
	pWnd=GetDlgItem(IDC_BUTTON3);
	pWnd->EnableWindow(true);

	pWnd=GetDlgItem(IDC_BUTTON4);
	pWnd->EnableWindow(true);

	pWnd=GetDlgItem(IDC_BUTTON5);
	pWnd->EnableWindow(true);

	pWnd=GetDlgItem(IDC_BUTTON6);
	pWnd->EnableWindow(true);

	pWnd=GetDlgItem(IDC_BUTTON2);
	pWnd->EnableWindow(false);



		CString strFileName="TVXQ_Save_1997.mdb"; //��ȡ�ļ����Լ�·����
		m_DBFileName = strFileName;
		m_strStatic1 = strFileName;
		UpdateData(false);

	
	//�����ݿ⣬������¼���϶���
	m_pDatabase = new CDaoDatabase;
	try{
		m_pDatabase->Open(m_DBFileName);
		m_pRecordset = new CDaoRecordset(m_pDatabase);
		m_ctrList1.EnableWindow(true);
	}
	catch (CDaoException* e){
		e->ReportError();
		delete m_pDatabase;
		m_pDatabase = NULL;
		e->Delete();
		return;
	}

	
	UpdateView();  //���⺯���ж�ȡ���ݿ�
					//������ListView
	
}

void CCassiopeia_313751158View::OnButton3() 
{
	// TODO: Add your control notification handler code here
	if(m_pRecordset) 
	{
		if(m_pRecordset->IsOpen()) m_pRecordset->Close();
		delete m_pRecordset;
		m_pRecordset = NULL;
	}

	if(m_pDatabase->IsOpen()) 
	{
		m_pDatabase->Close();
		delete m_pDatabase;
		m_pDatabase = NULL;

	}

	m_ctrList1.DeleteAllItems();
	m_ctrList1.EnableWindow(false);

	m_strStatic1 = "δ����                           ";


	CWnd* pWnd;
	pWnd=GetDlgItem(IDC_BUTTON2);
	pWnd->EnableWindow(true);

	pWnd=GetDlgItem(IDC_BUTTON4);
	pWnd->EnableWindow(false);

	pWnd=GetDlgItem(IDC_BUTTON5);
	pWnd->EnableWindow(false);

	pWnd=GetDlgItem(IDC_BUTTON6);
	pWnd->EnableWindow(false);


	UpdateData(false);
}

bool CCassiopeia_313751158View::UpdateView()
{
	//��ʾ���֣������ǰ��List
	m_ctrList1.EnableWindow(true);
	m_ctrList1.DeleteAllItems();
	while (m_ctrList1.DeleteColumn(0))
	{
		m_ctrList1.DeleteColumn(0);
	}
	int nListCol = m_ctrList1.GetHeaderCtrl()->GetItemCount();//��ȡ������
	if (nListCol > 0)
	{	for (int i=0;i<nListCol;i++)
	{	m_ctrList1.DeleteColumn(i);
	}
	}
	
	//��ȡ���ݿ��еġ�student_info_table����Ľṹ
	//д��FormView�е�CListCtrl�ؼ��С�
	m_strTableName = _T("student_info_table");	// ���õ�ǰ���������ݿ������
	int nFields;
	CDaoFieldInfo fieldInfo;			// ȡ��Ľṹ��Ϣ
	CDaoTableDef td(m_pDatabase);		// �����
	try{
		td.Open(m_strTableName);		//��ָ�����Ƶı�
		nFields = td.GetFieldCount()-3;	//��ȡ�ñ������
		for (int j=0; j < nFields; j++){
			td.GetFieldInfo(j,fieldInfo); //��ȡÿ��������Ϣ
			int nWidth = m_ctrList1.GetStringWidth(fieldInfo.m_strName) + 15;
			m_ctrList1.InsertColumn(j,fieldInfo.m_strName,LVCFMT_LEFT, nWidth);
		}
	}catch (CDaoException* e){
		e->ReportError(); 
		e->Delete();
		return false;
	}
	td.Close();
	
	
	//��ȡ������ݣ�д��FormView�е�CListCtrl�ؼ��С�
	int nItem = 0;
	try{
		//ƴһ��SQL��ѯ��䣺select * from [student_info_table]
		CString strSelect(_T("Select * From ["));
		strSelect += m_strTableName;
		strSelect += _T("]");   
		//ָ��m_pRecordset����Ϊ��̬����,ͬʱ��ѯ

		strSelect.Format("SELECT * FROM student_info_table WHERE ����='%s' ",
		IDName);
		m_pRecordset->Open(dbOpenDynaset,strSelect);
		
		while (!m_pRecordset->IsEOF()) 
		{
			COleVariant var;
			var = m_pRecordset->GetFieldValue(0); //��0��
			m_ctrList1.InsertItem(nItem,strVARIANT(var));
			for (int i=0; i < nFields; i++){
				var = m_pRecordset->GetFieldValue(i);
				CString strItem = strVARIANT(var);
				int width1 = m_ctrList1.GetColumnWidth(i);
				int width2 = m_ctrList1.GetStringWidth(strItem)+15;
				if (width2 > width1){
					m_ctrList1.SetColumnWidth(i,width2);
				}
				m_ctrList1.SetItemText( nItem,i,strItem);
			}
			nItem++;
			m_pRecordset->MoveNext();
		}
	}
	catch (CDaoException* e)
	{
		e->ReportError(); 
		e->Delete();
		return false;
	}
	
	return true;
}


CString CCassiopeia_313751158View::strVARIANT(const COleVariant& var)
{
    CString strRet;

    switch(var.vt)
    {
    case VT_EMPTY:
    case VT_NULL:
        strRet=_T("NULL");
        break;
    case VT_I2:
        strRet.Format(_T("%hd"),V_I2(&var));
        break;
    case VT_I4:
        strRet.Format(_T("%d"),V_I4(&var));
        break;
    case VT_R4:
        strRet.Format(_T("%e"),(double)V_R4(&var));
        break;
    case VT_R8:
        strRet.Format(_T("%e"),V_R8(&var));
        break;
    case VT_CY:
        strRet=COleCurrency(var).Format();
        break;
    case VT_DATE:
        strRet=COleDateTime(var).Format(_T("%m%d%y"));
        break;
    case VT_BSTR:
        strRet=V_BSTRT(&var);
        break;
    case VT_DISPATCH:
        strRet=_T("VT_DISPATCH");
        break;
    case VT_ERROR:
        strRet=_T("VT_ERROR");
        break;
    case VT_BOOL:
        //return strBOOL(V_BOOL(&var));
    case VT_VARIANT:
        strRet=_T("VT_VARIANT");
        break;
    case VT_UNKNOWN:
        strRet=_T("VT_UNKNOWN");
        break;
    case VT_I1:
        strRet=_T("VT_I1");
        break;
    case VT_UI1:
        strRet.Format(_T("0x%02hX"),(unsigned short)V_UI1(&var));
        break;
    case VT_UI2:
        strRet=_T("VT_UI2");
        break;
    case VT_UI4:
        strRet=_T("VT_UI4");
        break;
    case VT_I8:
        strRet=_T("VT_I8");
        break;
    case VT_UI8:
        strRet=_T("VT_UI8");
        break;
    case VT_INT:
        strRet=_T("VT_INT");
        break;
    case VT_UINT:
        strRet=_T("VT_UINT");
        break;
    case VT_VOID:
        strRet=_T("VT_VOID");
        break;
    case VT_HRESULT:
        strRet=_T("VT_HRESULT");
        break;
    case VT_PTR:
        strRet=_T("VT_PTR");
        break;
    case VT_SAFEARRAY:
        strRet=_T("VT_SAFEARRAY");
        break;
    case VT_CARRAY:
        strRet=_T("VT_CARRAY");
        break;
    case VT_USERDEFINED:
        strRet=_T("VT_USERDEFINED");
        break;
    case VT_LPSTR:
        strRet=_T("VT_LPSTR");
        break;
    case VT_LPWSTR:
        strRet=_T("VT_LPWSTR");
        break;
    case VT_FILETIME:
        strRet=_T("VT_FILETIME");
        break;
    case VT_BLOB:
        strRet=_T("VT_BLOB");
        break;
    case VT_STREAM:
        strRet=_T("VT_STREAM");
        break;
    case VT_STORAGE:
        strRet=_T("VT_STORAGE");
        break;
    case VT_STREAMED_OBJECT:
        strRet=_T("VT_STREAMED_OBJECT");
        break;
    case VT_STORED_OBJECT:
        strRet=_T("VT_STORED_OBJECT");
        break;
    case VT_BLOB_OBJECT:
        strRet=_T("VT_BLOB_OBJECT");
        break;
    case VT_CF:
        strRet=_T("VT_CF");
        break;
    case VT_CLSID:
        strRet=_T("VT_CLSID");
        break;
	}
	
	WORD vt=var.vt;
	
	if(vt&VT_ARRAY)
	{
		vt=vt&~VT_ARRAY;
		strRet=_T("Array of");
	}
	
	if(vt&VT_BYREF)
	{
		vt=vt&~VT_BYREF;
		strRet+=_T("Pointer to");
	}

	if(vt!=var.vt)
	{	
		switch(vt)
		{
		case VT_EMPTY:
		    strRet+=_T("VT_EMPTY");
		    break;
		case VT_NULL:
		  strRet+=_T("VT_NULL");
	        break;
		case VT_I2:
			strRet+=_T("VT_I2");
			break;
		case VT_I4:
			strRet+=_T("VT_I4");
			break;
		case VT_R4:
        strRet+=_T("VT_R4");
        break;
    case VT_R8:
        strRet+=_T("VT_r8");
        break;
    case VT_CY:
        strRet+=_T("VT_CY");
        break;
    case VT_DATE:
        strRet+=_T("VT_DATE");
        break;
    case VT_BSTR:
        strRet+=_T("VT_BSTR");
        break;
    case VT_DISPATCH:
        strRet+=_T("VT_DISPATCH");
        break;
    case VT_ERROR:
        strRet+=_T("VT_ERROR");
        break;
    case VT_BOOL:
        strRet+=_T("VT_BOOL");
        break;
    case VT_VARIANT:
        strRet+=_T("VT_VARIANT");
        break;
    case VT_UNKNOWN:
        strRet+=_T("VT_UNKNOWN");
        break;
    case VT_I1:
        strRet+=_T("VT_I1");
        break;
    case VT_UI1:
        strRet+=_T("VT_UI1");
        break;
    case VT_UI2:
        strRet+=_T("VT_UI2");
        break;
    case VT_UI4:
        strRet+=_T("VT_UI4");
        break;
    case VT_I8:
        strRet+=_T("VT_I8");
        break;
    case VT_UI8:
        strRet+=_T("VT_UI8");
        break;
    case VT_INT:
        strRet+=_T("VT_INT");
        break;
    case VT_UINT:
        strRet+=_T("VT_UINT");
        break;
    case VT_VOID:
        strRet+=_T("VT_VOID");
        break;
    case VT_HRESULT:
        strRet+=_T("VT_HRESULT");
        break;
    case VT_PTR:
        strRet+=_T("VT_PTR");
        break;
    case VT_SAFEARRAY:
        strRet+=_T("VT_SAFEARRAY");
        break;
    case VT_CARRAY:
        strRet+=_T("VT_CARRAY");
        break;
    case VT_USERDEFINED:
        strRet+=_T("VT_USERDEFINED");
        break;
    case VT_LPSTR:
        strRet+=_T("VT_LPSTR");
        break;
    case VT_LPWSTR:
        strRet+=_T("VT_LPWSTR");
        break;
    case VT_FILETIME:
        strRet+=_T("VT_FILETIME");
        break;
    case VT_BLOB:
        strRet+=_T("VT_BLOB");
        break;
    case VT_STREAM:
        strRet+=_T("VT_STREAM");
        break;
    case VT_STORAGE:
        strRet+=_T("VT_STORAGE");
        break;
    case VT_STREAMED_OBJECT:
        strRet+=_T("VT_STREAMED_OBJECT");
        break;
    case VT_STORED_OBJECT:
        strRet+=_T("VT_STORED_OBJECT");
        break;
    case VT_BLOB_OBJECT:
        strRet+=_T("VT_BLOB_OBJECT");
        break;
    case VT_CF:
        strRet+=_T("VT_CF");
        break;
    case VT_CLSID:
        strRet+=_T("VT_CLSID");
        break;
		}
	}

	return strRet;
}

void CCassiopeia_313751158View::OnButton4() 
{
	//���
	//��������Ƿ�����
	UpdateData(true);
	CTime tm,hm;
	hm=CTime::GetCurrentTime();
	CString Hour;
	Hour=hm.Format("%H : %M : %S");
	CString Date,DateAdd;
	m_timeTime.GetTime(tm);       //m_timeΪ���ʱ��ѡ������CTime���͵ı�����ȡʱ�䵽tm��
	Date=tm.Format("%Y-%m-%d");   //ת����CString����
	DateAdd=Date+" "+Hour;
	UpdateData(false);
	UpdateData(1);
	CString temp;
	switch(radio1)
	{
	case 0:temp="����";break;
	case 1:temp="֧��";break;
	}

	CString temp1;
	switch(radio2)
	{
	case 0:temp1="�ֽ�";break;
	case 1:temp1="���ÿ�";break;
	case 2:temp1="���";break;
	}

	if (m_floEdit1.GetLength()==0||radio1==5||radio2==40)
	{	
		MessageBox("��ֹ����Ϣ����ȫ��");
		return;
	}

	CString strGender;
	m_ctrCombo1.GetWindowText(strGender);
	
	if (strGender.GetLength() == 0)
	{	
		strGender = "NULL";
	}

	if (m_strEdit2.GetLength() == 0)
	{	
		m_strEdit2 = "NULL";
	}
	
	UpdateData(0);
	
	//����׼����ϣ���ʼд������
	m_strTableName = "student_info_table";
	if(!m_pDatabase->IsOpen()) return;// ����DAO���ݿ�������Ч��
	if(!m_pRecordset) return;
	if(m_pRecordset->IsOpen()) m_pRecordset->Close();
	// ƴһ��SQL���
	CString strSql;
	if (radio1==1)
	{
		m_floEdit1="-"+m_floEdit1;
	}
	strSql.Format("insert into student_info_table(����,���,����,�������,��;����,����˵��,������,����ɾ,����) values('%s','%s','%s','%s','%s','%s','%s','%s','%s')",\
		DateAdd,m_floEdit1,temp,temp1,strGender,m_strEdit2,Date,DateAdd,IDName);	 
	try{
		if(m_pDatabase->CanUpdate())
			m_pDatabase->Execute(strSql, dbDenyWrite|dbConsistent);
	}
	catch(CDaoException* e){
		e->ReportError();
		e->Delete();
		return;
	}
	
	//д����ɣ�����view
	UpdateView();

	
}


bool CCassiopeia_313751158View::DeleteItem()
{	
	m_strTableName = "student_info_table";
	
	if(!m_pDatabase->IsOpen()) return false;
	if(!m_pRecordset) return false;
	if(m_pRecordset->IsOpen()) m_pRecordset->Close();
	
	//��ȡ��ǰѡ����������
	int nSelect = m_ctrList1.GetSelectedCount(); 
	if (nSelect > 0) 
	{
		POSITION pos = m_ctrList1.GetFirstSelectedItemPosition();
		int np = (int)pos;
		np--;			//��������
		CString strID;	// ��ȡ��ǰ��Ŀ��ID������IDƴɾ��SQL����
		strID = m_ctrList1.GetItemText(np,0);
		CString strSQL;
		strSQL.Format("delete from %s where ����ɾ='%s' and ����='%s' ",
			m_strTableName, strID,IDName);
		try{
			m_pDatabase->Execute(strSQL);
		}
		catch (CDaoException* e) {
			e->ReportError(); 
			e->Delete();
			return false;
		}

		m_ctrList1.DeleteItem(np);
		UpdateData(false);
	}


	return true;
}

void CCassiopeia_313751158View::OnRadio1() 
{
	radio1=0;
	m_ctrCombo1.ResetContent();
	m_ctrCombo1.AddString("����");
	m_ctrCombo1.AddString("��ĸ");
		
	m_ctrCombo1.SetCurSel(0);
	
}

void CCassiopeia_313751158View::OnRadio2() 
{
	radio1=1;
	m_ctrCombo1.ResetContent();
	m_ctrCombo1.AddString("���");
	m_ctrCombo1.AddString("����");
		
	m_ctrCombo1.SetCurSel(0);
}

void CCassiopeia_313751158View::OnRadio3() 
{
	radio2=0;
}

void CCassiopeia_313751158View::OnRadio4() 
{
	radio2=1;	
}

void CCassiopeia_313751158View::OnRadio5() 
{
	radio2=2;
}

BOOL CCassiopeia_313751158View::PreTranslateMessage(MSG* pMsg) 
{
	// TODO: Add your specialized code here and/or call the base class
	CWnd  *pwnd = GetDlgItem(IDC_LIST2); 
	if( pMsg->message == WM_KEYDOWN )  
    {  
		switch( pMsg->wParam )
		{  
		case VK_DELETE:
			if(GetFocus() == pwnd){ //�жϽ����ڲ���IDC_LIST1�� 
				DeleteItem();//��ɾ����������������һ������
			}
			break;
		default:
			break;
		}
	}  
	
	return CFormView::PreTranslateMessage(pMsg);
}

void CCassiopeia_313751158View::OnButton5() 
{
	// TODO: Add your control notification handler code here
	DeleteItem();
	
}

void CCassiopeia_313751158View::OnButton6() 
{
	//�޸�	
	UpdateData(true);
	CTime tm,hm;
	hm=CTime::GetCurrentTime();
	CString Hour;
	Hour=hm.Format("%H : %M : %S");
	CString Date,DateAdd;
	m_timeTime.GetTime(tm);       //m_timeΪ���ʱ��ѡ������CTime���͵ı�����ȡʱ�䵽tm��
	Date=tm.Format("%Y-%m-%d");   //ת����CString����
	DateAdd=Date+" "+Hour;
	UpdateData(false);
	UpdateData(1);
	CString temp;
	switch(radio1)
	{
	case 0:temp="����";break;
	case 1:temp="֧��";break;
	}

	CString temp1;
	switch(radio2)
	{
	case 0:temp1="�ֽ�";break;
	case 1:temp1="���ÿ�";break;
	case 2:temp1="���";break;
	}

	if (m_floEdit1.GetLength()==0||radio1==5||radio2==40)
	{	
		MessageBox("��ֹ����Ϣ����ȫ��");
		return;
	}

	CString strGender;
	m_ctrCombo1.GetWindowText(strGender);
	
	if (strGender.GetLength() == 0)
	{	
		strGender = "NULL";
	}

	if (m_strEdit2.GetLength() == 0)
	{	
		m_strEdit2 = "NULL";
	}
	DeleteItem();
	UpdateData(0);
	
	//����׼����ϣ���ʼд������
	m_strTableName = "student_info_table";
	if(!m_pDatabase->IsOpen()) return;// ����DAO���ݿ�������Ч��
	if(!m_pRecordset) return;
	if(m_pRecordset->IsOpen()) m_pRecordset->Close();
	// ƴһ��SQL���
	CString strSql;
	if (radio1==1)
	{
		m_floEdit1="-"+m_floEdit1;
	}
	strSql.Format("insert into student_info_table(����,���,����,�������,��;����,����˵��,������,����ɾ,����) values('%s','%s','%s','%s','%s','%s','%s','%s','%s')",\
		DateAdd,m_floEdit1,temp,temp1,strGender,m_strEdit2,Date,DateAdd,IDName);	 
	try{
		if(m_pDatabase->CanUpdate())
			m_pDatabase->Execute(strSql, dbDenyWrite|dbConsistent);
	}
	catch(CDaoException* e){
		e->ReportError();
		e->Delete();
		return;
	}
	
	//д����ɣ�����view
	UpdateView();

}

void CCassiopeia_313751158View::OnClickList2(NMHDR* pNMHDR, LRESULT* pResult) 
{
	// TODO: Add your control notification handler code here
	
	*pResult = 0;
	
	m_strTableName = "student_info_table";
	
	if(!m_pDatabase->IsOpen()) return;
	if(!m_pRecordset) return;
	if(m_pRecordset->IsOpen()) m_pRecordset->Close();
	
	//��ȡ��ǰѡ����������
	int nSelect = m_ctrList1.GetSelectedCount(); 
	if (nSelect > 0) 
	{
		POSITION pos = m_ctrList1.GetFirstSelectedItemPosition();
		int np = (int)pos;
		np--;			//��������
		CString *str =new CString[6];
		
		for (int i=0;i<6;i++)
		{
		   str[i] = m_ctrList1.GetItemText(np, i);
		}

		double m=_tcstod(str[1],0);
		if (m>0)
		{
			m_floEdit1=str[1];
		}
		else
		{
			double z=m*(-1);
			CString  msg= _T("");
			msg.Format( _T("%.2lf"),z);  
			m_floEdit1=msg;

		}

		if (str[5]=="NULL")
		{
			m_strEdit2="";
		}
		else
			m_strEdit2=str[5];

		if (str[2]=="֧��")
		{
			CButton* pButton=(CButton*)GetDlgItem(IDC_RADIO2);
			pButton->SetCheck(true);
			CButton* pButton1=(CButton*)GetDlgItem(IDC_RADIO1);
			pButton1->SetCheck(false);
			OnRadio2();
		}
		else
		{
			CButton* pButton=(CButton*)GetDlgItem(IDC_RADIO1);
			pButton->SetCheck(true);
			CButton* pButton1=(CButton*)GetDlgItem(IDC_RADIO2);
			pButton1->SetCheck(false);
			OnRadio1();
		}
		
		if (str[3]=="�ֽ�")
		{
			CButton* pButton=(CButton*)GetDlgItem(IDC_RADIO3);
			pButton->SetCheck(true);
			CButton* pButton1=(CButton*)GetDlgItem(IDC_RADIO4);
			pButton1->SetCheck(false);
			CButton* pButton2=(CButton*)GetDlgItem(IDC_RADIO5);
			pButton2->SetCheck(false);
			radio2=0;
		}
		else if (str[3]=="���")
		{
			CButton* pButton=(CButton*)GetDlgItem(IDC_RADIO5);
			pButton->SetCheck(true);
			CButton* pButton1=(CButton*)GetDlgItem(IDC_RADIO4);
			pButton1->SetCheck(false);
			CButton* pButton2=(CButton*)GetDlgItem(IDC_RADIO3);
			pButton2->SetCheck(false);
			radio2=2;
		}
		else
		{
			CButton* pButton=(CButton*)GetDlgItem(IDC_RADIO4);
			pButton->SetCheck(true);
			CButton* pButton1=(CButton*)GetDlgItem(IDC_RADIO5);
			pButton1->SetCheck(false);
			CButton* pButton2=(CButton*)GetDlgItem(IDC_RADIO3);
			pButton2->SetCheck(false);
			radio2=1;
		}
		

		//ʱ���޸�!!!!�ɰ���!!!!!
 
		CDateTimeCtrl* pCtrl = (CDateTimeCtrl*)GetDlgItem(IDC_DATETIMEPICKER1);
		ASSERT(pCtrl!= NULL);

		int nY,nM,nD;
		sscanf(str[0],"%d-%d-%d",&nY,&nM,&nD);
		CTime timeTime(nY,nM,nD,0,0,0);

		VERIFY(pCtrl->SetTime(&timeTime));

		UpdateData(false);
	}

//	return;
}

void CCassiopeia_313751158View::OnKillFocus(CWnd* pNewWnd) 
{
	CFormView::OnKillFocus(pNewWnd);
	
	// TODO: Add your message handler code here
	
}

void CCassiopeia_313751158View::OnFileSave() 
{
	// TODO: Add your command handler code here
	UpdateData(true);
	CCassiopeia_313751158Doc* d=GetDocument();
	CString str;
	char temp[200];
	d->m_vctContent.clear(); 


	int n=m_ctrList1.GetItemCount();  

		str.Empty();
		CString temp1="���",temp2="����",temp3="�������",temp4="��;����",temp5="����˵��",nul="                                        ";
		str="����"+nul+temp1+"             "+temp2+"          "+temp3+"             "+temp4+"       "+temp5;
		str= str+"\r\n";
		str=str+"===============================================================";
		str= str+"\r\n";
		d->m_vctContent.push_back(str);



	for (int i=0;i<n;i++)
	{
		str.Empty();
		m_ctrList1.GetItemText(i,0,temp,200);
		str=str+temp;
		str=str+"	   ";
		m_ctrList1.GetItemText(i,1,temp,200);
		str=str+temp;
		str=str+"	       ";
		m_ctrList1.GetItemText(i,2,temp,200);
		str=str+temp;
		str=str+"	         ";
		m_ctrList1.GetItemText(i,3,temp,200);
		str=str+temp;
		str=str+"	     ";
		m_ctrList1.GetItemText(i,4,temp,200);
		str=str+temp;
		str=str+"	          ";
		m_ctrList1.GetItemText(i,5,temp,200);
		str=str+temp;
		str=str+"	   ";
		str= str+"\r\n";
		d->m_vctContent.push_back(str);
	}
	CString strname;	
	CString strtype="�ı��ļ�(*.txt)|*.txt|�����ļ�(*.*)|*.*||";
	
	CFileDialog MyDlg(  
		FALSE,			
		NULL,			
		"Cassiopeia.txt",		
		OFN_HIDEREADONLY|OFN_OVERWRITEPROMPT, 
		strtype,	
		NULL );			
	
	if (MyDlg.DoModal()==IDOK) 
	{
		strname=MyDlg.GetPathName(); 
		CFile   file; 
		file.Open(strname,CFile::modeWrite|CFile::modeCreate); 
		CArchive  ar(&file,CArchive::store); 
		d->Serialize(ar); 
		ar.Close(); 
		file.Close(); 
	}
	MessageBox("����ɹ���");
}

HBRUSH CCassiopeia_313751158View::OnCtlColor(CDC* pDC, CWnd* pWnd, UINT nCtlColor) 
{
	HBRUSH hbr = CFormView::OnCtlColor(pDC, pWnd, nCtlColor);
	
	// TODO: Change any attributes of the DC here

	if (pWnd->GetDlgCtrlID()==(IDC_STATIC))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(246,129,120));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}

	if (pWnd->GetDlgCtrlID()==(IDC_STATIC1))
	{
		pDC->SetBkColor(RGB(255,255,255));
		pDC->SetTextColor(RGB(138,136,204));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}

		
	if (pWnd->GetDlgCtrlID()==(IDC_RADIO1))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(138,136,204));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}

	if (pWnd->GetDlgCtrlID()==(IDC_RADIO2))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(138,136,204));

		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}

	if (pWnd->GetDlgCtrlID()==(IDC_RADIO3))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(138,136,204));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}

	if (pWnd->GetDlgCtrlID()==(IDC_RADIO4))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(138,136,204));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}

	if (pWnd->GetDlgCtrlID()==(IDC_RADIO5))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(138,136,204));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}
	// TODO: Return a different brush if the default is not desired
	return hbr;
}
