// Tab.cpp : implementation file
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"
#include "Tab.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CTab

IMPLEMENT_DYNCREATE(CTab, CFormView)

CTab::CTab()
	: CFormView(CTab::IDD)
{
	//{{AFX_DATA_INIT(CTab)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
}

CTab::~CTab()
{
}

void CTab::DoDataExchange(CDataExchange* pDX)
{
	CFormView::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CTab)
	DDX_Control(pDX, IDC_TAB1, m_ctrlTab);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CTab, CFormView)
	//{{AFX_MSG_MAP(CTab)
	ON_NOTIFY(TCN_SELCHANGE, IDC_TAB1, OnSelchangeTab1)
	ON_BN_CLICKED(IDC_STATIC_Hello, OnSTATICHello)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CTab diagnostics

#ifdef _DEBUG
void CTab::AssertValid() const
{
	CFormView::AssertValid();
}

void CTab::Dump(CDumpContext& dc) const
{
	CFormView::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CTab message handlers
void CTab::OnInitialUpdate() 
{
	CFormView::OnInitialUpdate();
	
	// TODO: Add your specialized code here and/or call the base class

	(CWnd* )GetDlgItem(IDC_STATIC_R)->ShowWindow(SW_HIDE);
	(CWnd* )GetDlgItem(IDC_STATIC_H)->ShowWindow(SW_HIDE);

	TC_ITEM item;
	item.mask = TCIF_TEXT;

	item.pszText = _T("µÇÂ¼");
	m_ctrlTab.InsertItem(0,&item);  

	item.pszText = _T("×¢²á");
	m_ctrlTab.InsertItem(1,&item);  

	item.pszText = _T("Èí¼þËµÃ÷");
	m_ctrlTab.InsertItem(2,&item); 
	
	m_TabLogin.Create(IDD_DIALOG2,&m_ctrlTab);
	m_TabLogin.SetWindowPos(NULL,10,20,600,400,SWP_SHOWWINDOW);

	m_TabR.Create(IDD_DIALOG3,&m_ctrlTab);
	m_TabR.SetWindowPos(NULL,10,20,600,400,SWP_HIDEWINDOW);

	m_TabHelp.Create(IDD_DIALOG4,&m_ctrlTab);
	m_TabHelp.SetWindowPos(NULL,10,20,600,400,SWP_HIDEWINDOW);
}




void CTab::OnSelchangeTab1(NMHDR* pNMHDR, LRESULT* pResult) 
{
	// TODO: Add your control notification handler code here

	int num = m_ctrlTab.GetCurSel(); 
    switch(num) 
    { 
    case 0:
		m_TabLogin.ShowWindow(SW_SHOW); 
		m_TabHelp.ShowWindow(SW_HIDE); 
		m_TabR.ShowWindow(SW_HIDE); 
		(CWnd* )GetDlgItem(IDC_STATIC_R)->ShowWindow(SW_HIDE);
		(CWnd* )GetDlgItem(IDC_STATIC_H)->ShowWindow(SW_HIDE);
		(CWnd* )GetDlgItem(IDC_STATIC_L)->ShowWindow(SW_SHOW);
		break; 
    case 1:	
		m_TabLogin.ShowWindow(SW_HIDE); 
		m_TabHelp.ShowWindow(SW_HIDE); 
		m_TabR.ShowWindow(SW_SHOW);
		(CWnd* )GetDlgItem(IDC_STATIC_L)->ShowWindow(SW_HIDE);
		(CWnd* )GetDlgItem(IDC_STATIC_H)->ShowWindow(SW_HIDE);
		(CWnd* )GetDlgItem(IDC_STATIC_R)->ShowWindow(SW_SHOW);
		break;
	case 2:	
		m_TabLogin.ShowWindow(SW_HIDE); 
		m_TabR.ShowWindow(SW_HIDE); 
		m_TabHelp.ShowWindow(SW_SHOW); 
		(CWnd* )GetDlgItem(IDC_STATIC_R)->ShowWindow(SW_HIDE);
		(CWnd* )GetDlgItem(IDC_STATIC_H)->ShowWindow(SW_SHOW);
		(CWnd* )GetDlgItem(IDC_STATIC_L)->ShowWindow(SW_HIDE);
		break;
    } 
	*pResult = 0;
}

void CTab::OnSTATICHello() 
{
	// TODO: Add your control notification handler code here
	(CWnd* )GetDlgItem(IDC_STATIC_Hello)->ShowWindow(SW_HIDE);
}
