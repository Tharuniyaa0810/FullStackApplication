import React, { useEffect, useRef } from 'react';
import '../assets/css/App.css'; // Import component-specific styles

import animationData from '../assets/lotties/privacy-anim.json'
import Lottie from 'lottie-web';
function PrivacyPolicy() {
  const container=useRef(null);
  useEffect(() => {
    const anim = Lottie.loadAnimation({
      container: container.current,
      renderer: 'svg',
      loop: true,
      autoplay: true,
      animationData: animationData,
    });


    return () => {
      anim.destroy();
    };
  }, []);
  useEffect(() => {
    const tabLists = document.querySelectorAll(".tabs_list ul li");
    const tabItems = document.querySelectorAll(".tab_item");

    tabLists.forEach((list) => {
      list.addEventListener("click", function () {
        const tabData = list.getAttribute("data-tc");

        tabLists.forEach((list) => {
          list.classList.remove("active");
        });
        list.classList.add("active");

        tabItems.forEach((item) => {
          const tabClass = item.getAttribute("class").split(" ");
          if (tabClass.includes(tabData)) {
            item.style.display = "block";
          } else {
            item.style.display = "none";
          }
        });
      });
    });
  }, []);

  return (
    <div className="terms-container">
    <div className="wrapper flex_align_justify">
    <div className='animation-container'>
        <div ref={container} className='animcon'></div>
      </div>
      <div className="tc_wrap">

        <div className="tabs_list">
          <ul>
            <li data-tc="tab_item_1" className="active">
            Information We Collect
            </li>
            <li data-tc="tab_item_2">How We Use Your Information</li>
            <li data-tc="tab_item_3">Information Sharing</li>
           
            <li data-tc="tab_item_4">Security</li>
          </ul>
        </div>
        <div className="tabs_content">
          <div className="tab_head">
            <h2>Privacy Policy</h2>
          </div>
          <div className="tab_body">
            <div className="tab_item tab_item_1">
              <h3>Information We Collect</h3>
              <h5>Personal Information:</h5>
              <p>
              We may collect names, email addresses, contact numbers, and other identifiable information when you create an account or engage in transactions with us.
                           </p>
                           <h5>Transaction Data:</h5>
                           <p> When you use our platform for currency exchange, we gather transaction details, such as currency pairs, exchange rates, transaction amounts, and timestamps.</p>
                           <h5>Log and Usage Information:</h5>
                           <p>Our servers automatically log information about your use of our platform. This includes IP addresses, browser types, operating systems, and the pages you access.</p>
                           <h5>Cookies and Tracking Technologies: </h5>
                           <p> We use cookies and similar technologies to enhance your experience on our website. These tools collect data such as browsing habits, preferences, and session information.</p>
              <h5>User Preferences:</h5>
              <p> To improve user experience, we may collect data on preferred currency exchange rates and historical transaction data.</p>
              {/* Other content for Terms of Use */}
            </div>
            <div className="tab_item tab_item_2" style={{ display: "none" }}>.
              <h3>How We Use Your Information</h3>
              <h5>Currency Exchange Services:</h5>
              <p>
              Your information is used to facilitate currency exchange transactions and provide accurate exchange rate information.                           </p>
                           <h5>Communication:</h5>
                           <p>We may use your contact details to communicate with you regarding transactions, account updates, and customer support.</p>
                           <h5>Personalization: </h5>
<p>We personalize your experience by using your preferences to display relevant exchange rates and transaction history.</p>             
              <h5>Analysis:</h5>
<p>We analyze user behavior to optimize our services, detect and prevent fraud, and improve our platform's functionality.</p>              <h5>User Preferences:</h5>
              <h5>Legal Compliance</h5>
              <p>
              Your information may be used to ensure compliance with applicable laws and regulations.              </p>
              {/* Other content for Intellectual Property Rights */}
            </div>
            <div className="tab_item tab_item_3" style={{ display: "none" }}>.
              <h3>Information Sharing</h3>
              <h5>Service Providers:</h5>
              <p>
            
              We may share your data with trusted service providers who assist us in delivering our services, subject to strict data protection agreements.</p>              {/* Other content for Intellectual Property Rights */}
           <h5>Legal Requirements:</h5>
           <p>We may disclose your information when required by law or to protect our rights, privacy, safety, or property, or that of our users or others.</p>
           <h5>Business Transactions</h5>
           <p> In the event of a merger, acquisition, or sale of assets, user information may be transferred to the acquiring entity.</p>
           <h5>User Consent: </h5>
           <p> We do not sell, rent, or trade your personal information for marketing purposes. However, with your consent, we may share data with partners to provide additional services, such as currency rate alerts.</p>
           
            </div>
            <div className="tab_item tab_item_4" style={{ display: "none" }}>.
              <h3>Security</h3>
              <h5>Encryption:</h5>
              <p>
              We use industry-standard encryption protocols to protect data during transmission and storage.            </p>
           <h5>Security Audits:</h5>
           <p>Regular security audits are conducted to identify and address potential vulnerabilities.</p>
           <h5>Access Controls:</h5>
           <p>Access to user data is restricted to authorized personnel only.</p>
            </div>
            {/* Repeat for other tabs */}
          </div>
        
        </div>
      </div>
    </div>
    </div>
  );
}

export default PrivacyPolicy;

